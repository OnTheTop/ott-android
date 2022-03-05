package com.unithon.ott.presentation.ui.home

import androidx.lifecycle.ViewModel
import com.unithon.ott.data.repository.MissionRepositoryImpl

class HomeViewModel : ViewModel() {
    private val missionRepository: MissionRepositoryImpl = MissionRepositoryImpl()
    val isFirst: Boolean? = missionRepository.getIsFirst()
    val isToday: Boolean? = missionRepository.getIsToday()

}