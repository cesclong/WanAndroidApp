package com.cesc.core

import android.app.Application
import com.tencent.mmkv.MMKV

object Startup {
    fun init(application: Application) {
        DIManager.doInject(application)

        MMKV.initialize(application)
    }
}