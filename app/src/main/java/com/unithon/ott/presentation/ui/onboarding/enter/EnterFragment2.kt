package com.unithon.ott.presentation.ui.onboarding.enter

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.unithon.ott.R
import com.unithon.ott.common.base.BaseFragment
import com.unithon.ott.databinding.FragmentEnterSecondBinding
import com.unithon.ott.presentation.ui.home.HomeActivity
import com.unithon.ott.presentation.ui.onboarding.StartViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

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
        initListener()
    }

    private fun initListener() {
        binding.enterSecondBtnComplete.setOnClickListener {
            lifecycleScope.launch {
                val postFamily = lifecycleScope.async {
                    startViewModel.postFamilyMember()
                }
                postFamily.await()
                startActivity(Intent(context, HomeActivity::class.java))
            }
        }
    }

    private fun initBinding() {
        binding.enterSecondFragment = this
        binding.viewModel = startViewModel
    }


}