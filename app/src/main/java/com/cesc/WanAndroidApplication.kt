package com.cesc

import androidx.multidex.MultiDexApplication
import com.cesc.core.Startup

class WanAndroidApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        Startup.init(this)
    }
}