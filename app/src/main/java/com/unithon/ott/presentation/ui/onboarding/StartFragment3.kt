package com.unithon.ott.presentation.ui.onboarding

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.unithon.ott.R
import com.unithon.ott.common.base.BaseFragment
import com.unithon.ott.databinding.FragmentStartThirdBinding
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/**
새로운 패밀리 만들기
- 내 닉네임 정하기
 **/

class StartFragment3: BaseFragment<FragmentStartThirdBinding>(R.layout.fragment_start_third) {

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
        binding.thirdFragment = this
        binding.viewModel = startViewModel
    }

    private fun initListener() {
        binding.startThirdBtnComplete.setOnClickListener {
            lifecycleScope.launch {
                val postFamily = lifecycleScope.async {
                    startViewModel.postFamily()
                }
                postFamily.await()
                findNavController().navigate(R.id.action_third_start_fragment_to_fourth_start_fragment)
            }
        }
    }
}