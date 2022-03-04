package com.unithon.ott

import android.app.Application
import com.unithon.ott.data.local.SharedPreference

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        SharedPreference.getInstance(this)
    }
}