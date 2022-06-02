package com.cesc.core.data.repository

import com.cesc.core.data.IRepository
import com.cesc.core.data.datasource.HomeDataSource
import com.cesc.core.model.HomeBanner
import org.koin.core.annotation.Singleton

interface HomeBannerRepository : IRepository<Unit, List<HomeBanner>>

@Singleton
internal class HomeBannerRepositoryImpl(
    private val homeDataSource: HomeDataSource
) : HomeBannerRepository {
    override suspend fun invoke(param: Unit?): List<HomeBanner> = homeDataSource.getBanner()
}







