package com.cesc

import androidx.multidex.MultiDexApplication
import com.cesc.core.DIManager
import com.tencent.mmkv.MMKV

class WanAndroidApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        DIManager.doInject(this)
        MMKV.initialize(this)
    }
}