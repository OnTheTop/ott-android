package com.unithon.ott.data.remote.response

import com.unithon.ott.data.model.Mission

data class MissionListResponse(
    val familyNickName: String,
    val memberNickNames: ArrayList<String>,
    val gauge: Int,
    val missionInfo: ArrayList<Mission>
)
