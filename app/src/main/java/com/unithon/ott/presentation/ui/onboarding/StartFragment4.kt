package com.unithon.ott.presentation.ui.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.unithon.ott.R
import com.unithon.ott.common.base.BaseFragment
import com.unithon.ott.databinding.FragmentStartFourthBinding
import com.unithon.ott.presentation.ui.home.HomeActivity
import android.content.ClipData
import android.content.ClipboardManager

import android.content.Context.CLIPBOARD_SERVICE




class StartFragment4 : BaseFragment<FragmentStartFourthBinding>(R.layout.fragment_start_fourth){

    private val startViewModel: StartViewModel by activityViewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T =
                StartViewModel() as T
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBinding()
        initListener()
    }

    private fun initBinding() {
        binding.fourthFragment = this
        binding.viewModel = startViewModel

    }

    private fun initListener() {
        binding.startFourthBtnClose.setOnClickListener {
            startActivity(Intent(context, HomeActivity::class.java))
        }
        binding.startFourthBtnCopy.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, startViewModel.familyCode.value)
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }
}