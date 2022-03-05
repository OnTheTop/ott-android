package com.unithon.ott.data.remote.api

import com.unithon.ott.data.model.FamilyModel
import com.unithon.ott.data.remote.response.FamilyMemberResponse
import com.unithon.ott.data.remote.response.FamilyResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface FamilyService {

    @POST("/family")
    suspend fun postFamily(
        @Body familyModel : FamilyModel
    ) : Response<FamilyResponse>

    @POST("/family/{familyCode}")
    suspend fun postFamilyMember(
        @Body memberNickname : String,
        @Path("familyCode") familyCode : String
    ) : Response<FamilyMemberResponse>
}