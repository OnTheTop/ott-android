package com.unithon.ott.data.repository

import com.unithon.ott.data.local.LocalDataSourceImpl
import com.unithon.ott.data.remote.datasource.MissionDatasourceImpl
import com.unithon.ott.data.remote.response.MissionListResponse
import com.unithon.ott.domain.repository.MissionRepository
import retrofit2.Response

class MissionRepositoryImpl : MissionRepository {

    private val localDataSource: LocalDataSourceImpl
        get() = LocalDataSourceImpl()

    private val missionDataSource: MissionDatasourceImpl
        get() = MissionDatasourceImpl()

    override fun getIsFirst(): Boolean? = localDataSource.getIsFirst()
    override fun setIsFirst(isFirst: Boolean) {
        localDataSource.setIsFirst(isFirst)
    }

    override fun getIsToday(): Boolean? = localDataSource.getIsToday()
    override fun setIsToday(isToday: Boolean) {
        localDataSource.setIsToday(isToday)
    }

    override fun getMission(): Int? = localDataSource.getMission()
    override fun setMission(mission: Int) {
        localDataSource.setMission(mission)
    }

    override suspend fun getMissionList(familyId: Int): Response<MissionListResponse> =
        missionDataSource.getMissionList(familyId)
}