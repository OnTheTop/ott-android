package com.unithon.ott.data.local

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.unithon.ott.R

object SharedPreference {
    private var pref: SharedPreferences? = null

    fun getInstance(context: Context): SharedPreference {
        if (pref == null) {
            pref = context.getSharedPreferences(
                context.getString(R.string.shared_pref_key),
                Application.MODE_PRIVATE
            )
        }
        return this
    }

    // 이번이 처음인지
    private const val IS_FIRST = "IS_FIRST"
    fun getIsFirst(): Boolean? = pref?.getBoolean(IS_FIRST, true)
    fun setIsFirst(isFirst: Boolean) = pref?.edit()?.putBoolean(IS_FIRST, isFirst)?.apply()

    // 오늘 미션 수행 했는지
    private const val IS_TODAY = "IS_TODAY"
    fun getIsToday(): Boolean? = pref?.getBoolean(IS_TODAY, false)
    fun setIsToday(isToday: Boolean) = pref?.edit()?.putBoolean(IS_TODAY, isToday)?.apply()

    // 마지막으로 수행한 미션 번호
    private const val MISSION = "MISSION"
    fun getMission(): Int? = pref?.getInt(MISSION, -1)
    fun setMission(mission: Int) = pref?.edit()?.putInt(MISSION, mission)?.apply()

    private const val FAMILY_CODE = "FAMILY_CODE"
    fun getFamilyCode() : String? = pref?.getString(FAMILY_CODE, null)
    fun setFamilyCode(code : String) = pref?.edit()?.putString(FAMILY_CODE,code)?.apply()

    private const val FAMILY_ID = "FAMILY_ID"
    fun getFamilyId() : Int?= pref?.getInt(FAMILY_ID , -1)
    fun setFamilyId(id : Int) = pref?.edit()?.putInt(FAMILY_ID,id)?.apply()

    private const val NICKNAME = "NICKNAME"
    fun getNickName() : String?= pref?.getString(NICKNAME, null)
    fun setNickName(nickname : String)= pref?.edit()?.putString(NICKNAME, nickname)?.apply()

    private const val USER_ID= "USER_ID"
    fun getUserId() : Int?= pref?.getInt(USER_ID , -1)
    fun setUserId(id : Int)= pref?.edit()?.putInt(USER_ID,id)?.apply()

    private const val IS_LEADER= "IS_LEADER"
    fun getIsLeader() : Boolean?= pref?.getBoolean(IS_LEADER, false)
    fun setIsLeader(isLeader : Boolean)= pref?.edit()?.putBoolean(IS_LEADER, isLeader)?.apply()
}