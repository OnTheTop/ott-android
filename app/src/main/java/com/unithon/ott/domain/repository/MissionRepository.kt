package com.unithon.ott.domain.repository

interface MissionRepository {
    fun getIsFirst(): Boolean?
    fun setIsFirst(isFirst: Boolean)

    fun getIsToday(): Boolean?
    fun setIsToday(isToday: Boolean)

    fun getMission(): Int?
    fun setMission(mission: Int)
}