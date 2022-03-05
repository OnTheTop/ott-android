package com.unithon.ott.domain.repository

import com.unithon.ott.data.remote.response.MissionListResponse
import retrofit2.Response

interface MissionRepository {
    fun getIsFirst(): Boolean?
    fun setIsFirst(isFirst: Boolean)

    fun getIsToday(): Boolean?
    fun setIsToday(isToday: Boolean)

    fun getMission(): Int?
    fun setMission(mission: Int)

    suspend fun getMissionList(familyId:Int):Response<MissionListResponse>
}