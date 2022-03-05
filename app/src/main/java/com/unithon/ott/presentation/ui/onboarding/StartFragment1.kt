package com.unithon.ott.presentation.ui.onboarding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.unithon.ott.R
import com.unithon.ott.common.base.BaseFragment
import com.unithon.ott.databinding.FragmentStartFirstBinding

/**
 진입화면
 **/

class StartFragment1 : BaseFragment<FragmentStartFirstBinding>(R.layout.fragment_start_first) {

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
      binding.firstFragment = this
      binding.viewModel = startViewModel
     }

    private fun initListener() {
        binding.startFirstBtnCreateFamily.setOnClickListener {
            findNavController().navigate(R.id.action_first_write_fragment_to_second_write_fragment)
        }

        binding.startFirstBtnEnterFamily.setOnClickListener {
            findNavController().navigate(R.id.action_first_start_fragment_to_first_enter_fragment)
        }
    }
}