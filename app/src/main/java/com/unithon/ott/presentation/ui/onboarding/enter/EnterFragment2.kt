package com.unithon.ott.presentation.ui.onboarding.enter

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.unithon.ott.R
import com.unithon.ott.common.base.BaseFragment
import com.unithon.ott.databinding.FragmentEnterSecondBinding
import com.unithon.ott.presentation.ui.onboarding.StartViewModel

/**
패밀리 참여하기
- 내 닉네임 입력하기
 **/

class EnterFragment2 : BaseFragment<FragmentEnterSecondBinding>(R.layout.fragment_enter_second){
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
        binding.enterSecondFragment = this
        binding.viewModel = startViewModel
    }
}