package com.unithon.ott.data.remote.api

import com.unithon.ott.data.remote.response.MissionListResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MissionService {
    @GET("missions/family/{familyId}")
    suspend fun getMissionList(
        @Path("familyId") familyId:Int
    ):Response<MissionListResponse>
}