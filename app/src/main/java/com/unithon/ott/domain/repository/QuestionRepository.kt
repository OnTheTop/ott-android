package com.unithon.ott.domain.repository

import com.unithon.ott.data.remote.response.MissionResponse
import retrofit2.Response

interface QuestionRepository {
    suspend fun getQuestionMission(missionId: Int, familyId: Int) : Response<MissionResponse>
}