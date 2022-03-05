package com.unithon.ott.data.local

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
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


}