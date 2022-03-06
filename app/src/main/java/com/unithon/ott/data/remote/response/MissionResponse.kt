package com.unithon.ott.data.remote.response

data class MissionResponse(
    val answerInfo: List<Any>,
    val content: String,
    val date: String,
    val isTotalAnswerCompleted: Boolean
)