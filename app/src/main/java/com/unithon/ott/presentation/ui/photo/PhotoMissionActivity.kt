package com.unithon.ott.presentation.ui.photo

import android.Manifest
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.unithon.ott.R
import com.unithon.ott.common.base.BaseActivity
import com.unithon.ott.common.utils.PhotoType
import com.unithon.ott.databinding.ActiviyPhotoMissionBinding

class PhotoMissionActivity : BaseActivity<ActiviyPhotoMissionBinding>(R.layout.activiy_photo_mission) {
    private lateinit var reviewImageLauncher: ActivityResultLauncher<Intent>
    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                photoType = PhotoType.PAST
                openGalleryListener(photoType)
            }
        }
    private val photoMissionViewModel : PhotoMissionViewModel by viewModels()
    private lateinit var photoType : PhotoType

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBinding()
        openGallery()

        photoMissionViewModel.pastImage.observe(this){
            binding.ivPhotoMissionPast.setImageURI(it)
        }
        photoMissionViewModel.recentImage.observe(this){
            binding.ivPhotoMissionRecent.setImageURI(it)
        }
    }

    private fun initBinding() {
        binding.photoActivity = this
        binding.photoViewModel = photoMissionViewModel
    }

    private fun openGallery() {
        reviewImageLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == RESULT_OK) {
                    val intentResult = if (it.data == null) {
                        return@registerForActivityResult
                    } else {
                        it.data
                    }
                    intentResult?.clipData?.apply {
                        val uri = this.getItemAt(0).uri
                        val path = uriToPath(context = this@PhotoMissionActivity, uri)
                        if(photoType == PhotoType.PAST){
                            photoMissionViewModel.setPastImage(uri)
                        }else{
                            photoMissionViewModel.setRecentImage(uri)
                        }
                    }
                }
            }
    }

    fun openGalleryListener(type : PhotoType) {
        when {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED -> {
                val intent = Intent(Intent.ACTION_PICK)
                intent.type = MediaStore.Images.Media.CONTENT_TYPE
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, false)
                intent.data = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                reviewImageLauncher.launch(intent)
                photoType = type
            }
            shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            -> {
                showDialogToGetPermission()
            }
            else -> {
                requestPermissionLauncher.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            }
        }
    }

    @SuppressLint("Range")
    fun uriToPath(context: Context, uri: Uri): String {
        val cursor: Cursor = context.contentResolver.query(uri, null, null, null, null) ?: return ""
        cursor.moveToNext()
        return cursor.getString(cursor.getColumnIndex("_data"))
    }

    private fun showDialogToGetPermission() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(resources.getString(R.string.img_permission_dialog_title))
            .setMessage(resources.getString(R.string.img_permission_dialog_message))

        builder.setPositiveButton(resources.getString(R.string.img_permission_dialog_ok)) { _, _ ->
            val intent = Intent(
                Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.fromParts("package", "com.unithon.ott", null)
            )
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
        builder.setNegativeButton(resources.getString(R.string.img_permission_dialog_dismiss)) { _, _ ->
            // ignore
        }
        val dialog = builder.create()
        dialog.show()
    }
}