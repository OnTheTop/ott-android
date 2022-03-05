package com.unithon.ott.presentation.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import com.unithon.ott.R
import com.unithon.ott.common.base.BaseActivity
import com.unithon.ott.databinding.ActivityHomeBinding
import com.unithon.ott.presentation.ui.album.AlbumActivity
import com.unithon.ott.presentation.ui.history.HistoryActivity

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


        // 삐삐 상태
//        if (viewModel.isFirst == true) { isFirst() }
//        else if (viewModel.isToday == true) { isDone() }
//        else { notDone() }
        isDone()



        binding.apply {
            homeBtnMenu.setOnClickListener {
                if (homeDl.isDrawerOpen(homeLlDrawer)) homeDl.closeDrawer(homeLlDrawer)
                else homeDl.openDrawer(homeLlDrawer)
            }
            homeBtnHistory.setOnClickListener {
                startActivity(Intent(this@HomeActivity, HistoryActivity::class.java))
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