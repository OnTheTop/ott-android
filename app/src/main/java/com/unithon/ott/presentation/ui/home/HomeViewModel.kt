package com.unithon.ott.presentation.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.unithon.ott.data.repository.MissionRepositoryImpl

class HomeViewModel : ViewModel() {
    private val missionRepository: MissionRepositoryImpl = MissionRepositoryImpl()
    val isFirst: Boolean? = missionRepository.getIsFirst()
    val isToday: Boolean? = missionRepository.getIsToday()
    val missionId: Int = missionRepository.getMissionId() ?: 1
    val type: MutableLiveData<String> = MutableLiveData()

    suspend fun getMissionId() {
        val response = missionRepository.getMission(missionId + 1, 2)
        if (response.isSuccessful) {
            Log.d("###", response.body().toString())
            type.postValue(response.body()?.category.toString())
            missionRepository.setMissionId(missionId + 1)
            missionRepository.setIsFirst(false)
            missionRepository.setIsToday(false)
        }
        else {
            Log.d("###", response.code().toString())
        }
    }

}