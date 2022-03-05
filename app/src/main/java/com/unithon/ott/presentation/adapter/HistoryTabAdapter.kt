package com.unithon.ott.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.unithon.ott.presentation.ui.history.AlbumFragment
import com.unithon.ott.presentation.ui.history.MissionFragment

class HistoryTabAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MissionFragment()
            1 -> AlbumFragment()
            else -> MissionFragment()
        }
    }
}