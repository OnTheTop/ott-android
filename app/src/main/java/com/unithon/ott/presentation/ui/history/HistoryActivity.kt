package com.unithon.ott.presentation.ui.history

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.unithon.ott.R
import com.unithon.ott.common.base.BaseActivity
import com.unithon.ott.databinding.ActivityHistoryBinding
import com.unithon.ott.presentation.adapter.HistoryTabAdapter
import com.unithon.ott.presentation.ui.home.HomeViewModel

class HistoryActivity : BaseActivity<ActivityHistoryBinding>(R.layout.activity_history) {

    private val viewModel: HistoryViewModel by viewModels()
    private val tabList by lazy {
        listOf(
            getString(R.string.history_tab_mission),
            getString(R.string.history_tab_album)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.apply {
            historyBtnMenu.setOnClickListener {
                historyBtnMenu.setOnClickListener {
                    if (historyDl.isDrawerOpen(historyLlDrawer)) historyDl.closeDrawer(
                        historyLlDrawer
                    )
                    else historyDl.openDrawer(historyLlDrawer)
                }
            }
            historyVp.apply {
                offscreenPageLimit = 2
                adapter = HistoryTabAdapter(this@HistoryActivity)
                registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                    }
                })
            }
            TabLayoutMediator(historyTl, historyVp) { tab, position ->
                tab.text = tabList[position]
            }.attach()
        }
    }
}