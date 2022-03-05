package com.unithon.ott.data.repository

import com.unithon.ott.data.remote.datasource.FamilyDatasource
import com.unithon.ott.data.remote.response.FamilyMemberResponse
import com.unithon.ott.data.remote.response.FamilyResponse
import com.unithon.ott.domain.repository.FamilyRepository
import retrofit2.Response

class FamilyRepositoryImpl: FamilyRepository  {
    private val familyDatasource : FamilyDatasource get() = FamilyDatasource()

    override suspend fun postFamily(
        familyNickName: String,
        memberNickname: String,
    ): Response<FamilyResponse> {
        return familyDatasource.postFamily(familyNickName,memberNickname)
    }

    override suspend fun postFamilyMember(
        memberNickname: String,
        familyCode: String,
    ): Response<FamilyMemberResponse> {
        return familyDatasource.postFamilyMember(memberNickname,familyCode)
    }
}