package com.unithon.ott.data.repository

import com.unithon.ott.data.remote.datasource.QuestionDataSource
import com.unithon.ott.data.remote.response.MissionResponse
import com.unithon.ott.domain.repository.QuestionRepository
import retrofit2.Response

class QuestionRepositoryImpl : QuestionRepository {
    private val questionDataSource : QuestionDataSource get() = QuestionDataSource()

    override suspend fun getQuestionMission(
        missionId: Int,
        familyId: Int,
    ): Response<MissionResponse> {
        return questionDataSource.getQuestionMission(missionId, familyId)
    }
}