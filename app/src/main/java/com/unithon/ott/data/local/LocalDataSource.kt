package com.unithon.ott.data.local

interface LocalDataSource {

    fun getIsFirst(): Boolean?
    fun setIsFirst(isFirst: Boolean)

    fun getIsToday(): Boolean?
    fun setIsToday(isToday: Boolean)

    fun getMission(): Int?
    fun setMission(mission: Int)

    fun getFamilyCode() : String?
    fun setFamilyCode(code : String)

    fun getFamilyId() : Int?
    fun setFamilyId(id : Int)

    fun getNickName() : String?
    fun setNickName(nickname : String)

    fun getUserId() : Int?
    fun setUserId(id : Int)

    fun getIsLeader() : Boolean?
    fun setIsLeader(isLeader : Boolean)
}

class LocalDataSourceImpl : LocalDataSource {
    override fun getIsFirst(): Boolean? = SharedPreference.getIsFirst()

    override fun setIsFirst(isFirst: Boolean) {
        SharedPreference.setIsFirst(isFirst)
    }

    override fun getIsToday(): Boolean? = SharedPreference.getIsToday()

    override fun setIsToday(isToday: Boolean) {
        SharedPreference.setIsToday(isToday)
    }

    override fun getMission(): Int? = SharedPreference.getMission()

    override fun setMission(mission: Int) {
        SharedPreference.setMission(mission)
    }

    override fun getFamilyCode(): String? = SharedPreference.getFamilyCode()

    override fun setFamilyCode(code: String) {
        SharedPreference.setFamilyCode(code)
    }

    override fun getFamilyId(): Int?  = SharedPreference.getFamilyId()

    override fun setFamilyId(id: Int) {
        SharedPreference.setFamilyId(id)
    }

    override fun getNickName(): String? = SharedPreference.getNickName()

    override fun setNickName(nickname: String) {
        SharedPreference.setNickName(nickname)
    }

    override fun getUserId(): Int? = SharedPreference.getUserId()

    override fun setUserId(id: Int) {
        SharedPreference.setUserId(id)
    }

    override fun getIsLeader(): Boolean? = SharedPreference.getIsLeader()

    override fun setIsLeader(isLeader: Boolean) {
        SharedPreference.setIsLeader(isLeader)
    }
}