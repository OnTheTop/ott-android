package com.unithon.ott.presentation.ui.album

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.unithon.ott.R
import com.unithon.ott.common.base.BaseActivity
import com.unithon.ott.databinding.ActivityAlbumBinding

class AlbumActivity : BaseActivity<ActivityAlbumBinding>(R.layout.activity_album) {

    // 가족 사진관

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[AlbumViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }
}