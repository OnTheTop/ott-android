package com.unithon.ott.presentation.ui.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.unithon.ott.data.model.Mission
import com.unithon.ott.data.remote.response.MissionListResponse
import com.unithon.ott.data.repository.MissionRepositoryImpl
import retrofit2.Response

class HistoryViewModel : ViewModel() {
    private val missionRepository: MissionRepositoryImpl
        get() = MissionRepositoryImpl()

    private val _familyNickname: MutableLiveData<String> = MutableLiveData()
    val familyNickname: LiveData<String>
        get() = _familyNickname
    private val _memberNickname: MutableLiveData<ArrayList<String>> = MutableLiveData()
    val memberNickname: LiveData<ArrayList<String>>
        get() = _memberNickname
    private val _gauge: MutableLiveData<Int> = MutableLiveData()
    val gauge: LiveData<Int>
        get() = _gauge
    private val _missionList: MutableLiveData<ArrayList<Mission>> = MutableLiveData(ArrayList())
    val missionList: LiveData<ArrayList<Mission>>
        get() = _missionList

    val familyId: Int = 1

    suspend fun getMissionList() {
        val missionListResponse: Response<MissionListResponse> =
            missionRepository.getMissionList(familyId)
        if (missionListResponse.isSuccessful) {
            _familyNickname.postValue(missionListResponse.body()?.familyNickName)
            _memberNickname.postValue(missionListResponse.body()?.memberNickNames)
            _gauge.postValue(missionListResponse.body()?.gauge)
            _missionList.postValue(missionListResponse.body()?.missionInfo)
        } else {
        }
    }
}