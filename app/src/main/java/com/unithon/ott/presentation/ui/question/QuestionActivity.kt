package com.unithon.ott.presentation.ui.question

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.unithon.ott.R
import com.unithon.ott.common.base.BaseActivity
import com.unithon.ott.databinding.ActivityQuestionBinding
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class QuestionActivity : BaseActivity<ActivityQuestionBinding>(R.layout.activity_question) {

    // 미션 1. 질문 답하기
    private val viewModel : QuestionViewModel by viewModels()
    private var missionID : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        missionID= intent.extras?.getInt("missionId")?: 0
        getMission(missionID)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.apply {
            questionAppbar.appbarIvBack.setOnClickListener { onBackPressed()
            }
        }
    }

    private fun getMission(missionId : Int){
        lifecycleScope.launch {
            viewModel.getMission(missionId)
        }
    }
}