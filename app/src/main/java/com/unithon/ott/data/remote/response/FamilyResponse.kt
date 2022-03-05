package com.unithon.ott.data.remote.response

data class FamilyResponse(
    val familyId : Int,
    val familyCode : String
)

data class FamilyMemberResponse(
    val familiy: Familiy,
    val id: Int,
    val isLeader: Boolean,
    val memberNickname: String
)

data class Familiy(
    val familyCode: String,
    val familyNickname: String,
    val gauge: Int,
    val id: Int,
    val memberCount: Int
)