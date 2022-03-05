package com.unithon.ott.data.local

interface LocalDataSource {

    fun getIsFirst(): Boolean?
    fun setIsFirst(isFirst: Boolean)

    fun getIsToday(): Boolean?
    fun setIsToday(isToday: Boolean)

    fun getMission(): Int?
    fun setMission(mission: Int)
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
}