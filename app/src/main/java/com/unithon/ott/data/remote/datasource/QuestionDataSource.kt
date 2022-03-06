package com.unithon.ott.data.remote.datasource

import com.unithon.ott.common.network.RetrofitClient
import com.unithon.ott.data.remote.api.QuestionService
import com.unithon.ott.data.remote.response.MissionResponse
import retrofit2.Response

class QuestionDataSource {

    suspend fun getQuestionMission(missionId: Int, familyId: Int) : Response<MissionResponse> =
        RetrofitClient.getClient().create(QuestionService::class.java).getQuestionMission(missionId,familyId)
}