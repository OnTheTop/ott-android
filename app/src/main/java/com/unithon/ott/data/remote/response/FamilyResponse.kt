package com.unithon.ott.data.remote.response

data class FamilyResponse(
    val familyId : Int,
    val familyCode : String,
    val memberId : Int,
    val memberNickname: String,
    val isLeader: Boolean
)
