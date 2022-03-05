package com.unithon.ott.domain.repository

import com.unithon.ott.data.remote.response.MissionListResponse
import com.unithon.ott.data.remote.response.MissionResponse
import retrofit2.Response

interface MissionRepository {
    fun getIsFirst(): Boolean?
    fun setIsFirst(isFirst: Boolean)

    fun getIsToday(): Boolean?
    fun setIsToday(isToday: Boolean)

    fun getMissionId(): Int?
    fun setMissionId(mission: Int)

    suspend fun getMissionList(familyId: Int): Response<MissionListResponse>
    suspend fun getMission(missionId: Int, familyId: Int): Response<MissionResponse>
}