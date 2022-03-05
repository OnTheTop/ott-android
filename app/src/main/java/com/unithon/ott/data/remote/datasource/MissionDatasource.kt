package com.unithon.ott.data.remote.datasource

import com.unithon.ott.common.network.RetrofitClient
import com.unithon.ott.data.remote.api.MissionService
import com.unithon.ott.data.remote.response.MissionListResponse
import retrofit2.Response

interface MissionDatasource {
    suspend fun getMissionList(familyId: Int): Response<MissionListResponse>
}

class MissionDatasourceImpl : MissionDatasource {
    override suspend fun getMissionList(familyId: Int): Response<MissionListResponse> =
        RetrofitClient.getClient().create(MissionService::class.java).getMissionList(familyId)

}
