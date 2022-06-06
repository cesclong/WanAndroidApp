package com.cesc.core.data.repository

import com.cesc.core.data.IRepository
import com.cesc.core.data.datasource.HomeDataSource
import com.cesc.core.model.Article
import com.cesc.core.model.HomeBanner
import org.koin.core.annotation.Singleton

interface HomeBannerRepository : IRepository<Unit, List<HomeBanner>>

@Singleton
internal class HomeBannerRepositoryImpl(
    private val homeDataSource: HomeDataSource
) : HomeBannerRepository {
    override suspend fun invoke(param: Unit?): List<HomeBanner> = homeDataSource.getBanner()
}


interface HomeTopArticleRepository : IRepository<Unit, List<Article>>


@Singleton
internal class HomeTopArticleRepositoryImpl(
    private val homeDataSource: HomeDataSource
) : HomeTopArticleRepository {
    override suspend fun invoke(param: Unit?): List<Article> = homeDataSource.getTopArticles()
}







