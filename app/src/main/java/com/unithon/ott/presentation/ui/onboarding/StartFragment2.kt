package com.unithon.ott.presentation.ui.onboarding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.unithon.ott.R
import com.unithon.ott.common.base.BaseFragment
import com.unithon.ott.databinding.FragmentStartSecondBinding

/**
새로운 패밀리 만들기
- 가족 닉네임 정하기
 **/

class StartFragment2: BaseFragment<FragmentStartSecondBinding>(R.layout.fragment_start_second) {

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
        binding.secondFragment = this
        binding.startViewModel = startViewModel

    }

    private fun initListener() {
        binding.startSecondBtnNext.setOnClickListener {
            findNavController().navigate(R.id.action_second_start_fragment_to_third_start_fragment)
        }
    }
}