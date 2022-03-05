package com.unithon.ott.data.model

import java.io.Serializable

data class Mission(
    val missionId: Int,
    val missionCategory: String,
    val completedMemberCount: Int,
    val memberCount: Int,
    val date: String
) : Serializable
