package com.unithon.ott.domain.repository

import com.unithon.ott.data.remote.response.FamilyMemberResponse
import com.unithon.ott.data.remote.response.FamilyResponse
import retrofit2.Response

interface FamilyRepository {
    suspend fun postFamily(
        familyNickName: String,
        memberNickname: String,
    ): Response<FamilyResponse>

    suspend fun postFamilyMember(
        memberNickname: String,
        familyCode: String,
    ): Response<FamilyMemberResponse>
}