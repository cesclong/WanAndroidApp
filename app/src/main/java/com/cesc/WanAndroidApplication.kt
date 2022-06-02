package com.cesc

import androidx.multidex.MultiDexApplication
import com.cesc.core.DIManager

class WanAndroidApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        DIManager.doInject(this)
    }
}