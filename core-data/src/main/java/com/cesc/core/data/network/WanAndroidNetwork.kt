package com.cesc.core.data.network

import com.cesc.core.model.HomeBanner

interface WanAndroidNetwork {
    suspend fun getHomeBanner(): List<HomeBanner>
}