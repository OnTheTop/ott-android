package com.unithon.ott.presentation.ui.onboarding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.unithon.ott.R
import com.unithon.ott.common.base.BaseFragment
import com.unithon.ott.databinding.FragmentStartFourthBinding

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
    }

    private fun initBinding() {
        binding.fourthFragment = this
        binding.viewModel = startViewModel

    }

    private fun initListener() {
        binding.startFourthBtnClose.setOnClickListener {
        }
    }
}