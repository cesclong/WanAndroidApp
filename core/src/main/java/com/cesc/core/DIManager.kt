package com.cesc.core

import android.content.Context
import com.cesc.core.data.DataDIModule
import com.cesc.core.domain.DomainDIModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

internal object DIManager {
    fun doInject(applicationContext: Context) {
        startKoin {
            androidContext(applicationContext)
            androidLogger()
            modules(
                DataDIModule().module, DomainDIModule().module
            )
        }
    }

}
