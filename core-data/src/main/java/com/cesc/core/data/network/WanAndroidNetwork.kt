package com.cesc.core.data.network

import com.cesc.core.model.Article
import com.cesc.core.model.HomeBanner
import com.cesc.core.model.LoginInBean

interface WanAndroidNetwork {
    suspend fun getHomeBanner(): List<HomeBanner>

    suspend fun getHomeTopArticles(): List<Article>

    suspend fun getHomeArticles(pageIndex: Int): List<Article>

    suspend fun login(username: String, password: String) : LoginInBean
    suspend fun logout(): Boolean
}