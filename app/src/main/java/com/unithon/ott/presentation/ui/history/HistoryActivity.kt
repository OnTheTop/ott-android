package com.unithon.ott.presentation.ui.history

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.unithon.ott.R
import com.unithon.ott.common.base.BaseActivity
import com.unithon.ott.databinding.ActivityHistoryBinding
import com.unithon.ott.presentation.ui.home.HomeViewModel

class HistoryActivity : BaseActivity<ActivityHistoryBinding>(R.layout.activity_history) {

    private val viewModel: HistoryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }
}