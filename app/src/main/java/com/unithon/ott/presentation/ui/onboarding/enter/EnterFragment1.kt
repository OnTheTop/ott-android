package com.unithon.ott.presentation.ui.onboarding.enter

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.unithon.ott.R
import com.unithon.ott.common.base.BaseFragment
import com.unithon.ott.databinding.FragmentEnterFirstBinding
import com.unithon.ott.presentation.ui.onboarding.StartViewModel

/**
 패밀리 참여하기
 - 가족 참여 코드 입력하기
 **/

class EnterFragment1 : BaseFragment<FragmentEnterFirstBinding>(R.layout.fragment_enter_first){

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
        binding.enterFirstFragment = this
        binding.viewModel = startViewModel
    }

    private fun initListener() {
        binding.enterFirstBtnNext.setOnClickListener {
            findNavController().navigate(R.id.action_first_enter_fragment_to_second_enter_fragment)
        }
    }
}