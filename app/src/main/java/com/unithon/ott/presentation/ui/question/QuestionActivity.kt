package com.unithon.ott.presentation.ui.question

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.unithon.ott.R
import com.unithon.ott.common.base.BaseActivity
import com.unithon.ott.databinding.ActivityQuestionBinding

class QuestionActivity : BaseActivity<ActivityQuestionBinding>(R.layout.activity_question) {

    // 미션 1. 질문 답하기
    private lateinit var viewModel :QuestionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.apply {
            questionAppbar.appbarIvBack.setOnClickListener { onBackPressed()
            }
        }
    }
}