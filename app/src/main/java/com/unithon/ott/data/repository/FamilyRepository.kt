package com.unithon.ott.data.repository

import com.unithon.ott.data.model.FamilyModel
import com.unithon.ott.data.remote.datasource.FamilyDatasource
import com.unithon.ott.data.remote.response.FamilyResponse
import com.unithon.ott.domain.repository.FamilyRepository
import retrofit2.Response

class FamilyRepositoryImpl: FamilyRepository  {
    private val familyDatasource : FamilyDatasource get() = FamilyDatasource()

    override suspend fun postFamily(
        familyModel : FamilyModel
    ): Response<FamilyResponse> {
        return familyDatasource.postFamily(familyModel)
    }

    override suspend fun postFamilyMember(
        memberNickname: String,
        familyCode: String,
    ): Response<FamilyResponse> {
        return familyDatasource.postFamilyMember(memberNickname,familyCode)
    }
}