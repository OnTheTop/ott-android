package com.unithon.ott.presentation.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.unithon.ott.data.model.Mission

@BindingAdapter("bind_missionList")
fun bindMissionList(rvMissionList:RecyclerView, missionList:ArrayList<Mission>) {
    missionList.run {
        ((rvMissionList.adapter) as MissionListAdapter).setMissionList(this)
    }
}