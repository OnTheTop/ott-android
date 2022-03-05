package com.unithon.ott.data.remote.datasource

import com.unithon.ott.common.network.RetrofitClient
import com.unithon.ott.data.remote.api.FamilyService
import com.unithon.ott.data.remote.response.FamilyMemberResponse
import com.unithon.ott.data.remote.response.FamilyResponse
import retrofit2.Response


class FamilyDatasource {

    suspend fun postFamily(
        familyNickName: String,
        memberNickname: String,
    ): Response<FamilyResponse> = RetrofitClient.getClient().create(FamilyService::class.java)
        .postFamily(familyNickName, memberNickname)

    suspend fun postFamilyMember(
        memberNickname: String,
        familyCode : String
    ) : Response<FamilyMemberResponse> = RetrofitClient.getClient().create(FamilyService::class.java)
        .postFamilyMember(memberNickname = memberNickname, familyCode = familyCode)
}