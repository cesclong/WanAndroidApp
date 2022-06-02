package com.cesc.core.data.datasource

import com.cesc.core.data.network.WanAndroidNetwork
import com.cesc.core.model.HomeBanner
import org.koin.core.annotation.Singleton

interface HomeDataSource {
    suspend fun getBanner(): List<HomeBanner>
}

@Singleton
internal class HomeRemoteDataSourceImpl(
    private val network: WanAndroidNetwork
) : HomeDataSource {
    override suspend fun getBanner(): List<HomeBanner> = network.getHomeBanner()

}