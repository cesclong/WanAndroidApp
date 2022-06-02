package com.cesc.core.data.network

import com.cesc.core.model.HomeBanner
import org.koin.core.annotation.Singleton

@Singleton
class RetrofitNetwork : WanAndroidNetwork {
    override suspend fun getHomeBanner(): List<HomeBanner> {
        return emptyList()
    }
}