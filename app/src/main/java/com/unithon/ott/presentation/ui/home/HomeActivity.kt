package com.unithon.ott.presentation.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.unithon.ott.R
import com.unithon.ott.common.base.BaseActivity
import com.unithon.ott.databinding.ActivityHomeBinding
import com.unithon.ott.presentation.ui.history.HistoryActivity
import com.unithon.ott.presentation.ui.photo.PhotoMissionActivity
import com.unithon.ott.presentation.ui.question.QuestionActivity
import kotlinx.coroutines.launch

class HomeActivity : BaseActivity<ActivityHomeBinding>(R.layout.activity_home) {

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[HomeViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.type.observe(this) { type ->
            if (type == "질문") {
                val intent = Intent(this, QuestionActivity::class.java)
                intent.putExtra("missionId", viewModel.missionId + 1)
                startActivity(intent)

            } else {
                startActivity(Intent(this, PhotoMissionActivity::class.java))
            }

        }

        // 삐삐 상태
        if (viewModel.isFirst == true) {
            isFirst()
        } else if (viewModel.isToday == true) {
            isDone()
        } else {
            notDone()
        }

        binding.apply {
            homeBtnMenu.setOnClickListener {
                if (homeDl.isDrawerOpen(homeLlDrawer)) homeDl.closeDrawer(homeLlDrawer)
                else homeDl.openDrawer(homeLlDrawer)
            }
            homeBtnHistory.setOnClickListener {
                startActivity(Intent(this@HomeActivity, HistoryActivity::class.java))
            }
            homeFirstBbibbi.setOnClickListener {
                lifecycleScope.launch {
                    viewModel?.getMissionId()
                }
            }
        }
    }

    private fun isFirst() {
        binding.homeTvGreeting.text = getString(R.string.home_tv_first_greeting)
        binding.homeTvIntro.text = getString(R.string.home_tv_first_intro)
    }

    private fun isDone() {
        binding.homeTvGreeting.text = getString(R.string.home_tv_done_greeting)
        binding.homeTvIntro.text = getString(R.string.home_tv_intro)
    }

    private fun notDone() {
        binding.homeTvGreeting.text = getString(R.string.home_tv_greeting)
        binding.homeTvIntro.text = getString(R.string.home_tv_intro)
    }

}