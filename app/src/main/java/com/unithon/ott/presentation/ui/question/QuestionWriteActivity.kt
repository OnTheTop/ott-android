package com.unithon.ott.presentation.ui.question

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.unithon.ott.R
import com.unithon.ott.common.base.BaseActivity
import com.unithon.ott.databinding.ActivityWriteQuestionBinding

class QuestionWriteActivity : BaseActivity<ActivityWriteQuestionBinding>(R.layout.activity_write_question) {

    private val writeViewModel : QuestionWriteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.lifecycleOwner = this
        binding.viewModel = writeViewModel
    }
}