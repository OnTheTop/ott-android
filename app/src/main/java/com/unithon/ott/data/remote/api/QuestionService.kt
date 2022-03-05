package com.unithon.ott.data.remote.api

import com.unithon.ott.data.remote.response.MissionResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface QuestionService {

    @GET("/missions/question/{missionID}/family/{familyId}")
    suspend fun getQuestionMission(
        @Path("missionID") missionID : Int,
        @Path("familyId") familyId : Int
    ): Response<MissionResponse>

}