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
}