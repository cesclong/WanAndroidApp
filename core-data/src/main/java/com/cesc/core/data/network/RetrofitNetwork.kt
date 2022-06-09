package com.cesc.core.data.network

import com.cesc.core.model.Article
import com.cesc.core.model.HomeArticleInfo
import com.cesc.core.model.HomeBanner
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.core.annotation.Named
import org.koin.core.annotation.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

internal interface WanAndroidApiService {
    @GET("banner/json")
    suspend fun getHomeBanner(): NetworkResponse<List<HomeBanner>>

    @GET("article/top/json")
    suspend fun getHomeTopArticles(): NetworkResponse<List<Article>>

    @GET("article/list/{pageIndex}/json")
    suspend fun getHomeArticles(@Path("pageIndex") pageIndex: Int): NetworkResponse<HomeArticleInfo>

}

data class NetworkResponse<T>(
    val data: T,
) : java.io.Serializable


@Singleton
class RetrofitNetwork(
    @Named("cookieSaver") private val cookieInterceptor: RetrofitInterceptor,
    @Named("headers") private val headersInterceptor: RetrofitInterceptor
) : WanAndroidNetwork {
    private val apiService = Retrofit.Builder()
        .client(
            OkHttpClient
                .Builder()
                .addInterceptor(cookieInterceptor)
                .addInterceptor(headersInterceptor)
                .build()
        )
        .baseUrl("https://www.wanandroid.com/")
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder()
                    .setLenient()
                    .create()
            )
        )
        .build()
        .create(WanAndroidApiService::class.java)

    override suspend fun getHomeBanner(): List<HomeBanner> {
        return apiService.getHomeBanner().data
    }

    override suspend fun getHomeTopArticles(): List<Article> {
        return apiService.getHomeTopArticles().data
    }

    override suspend fun getHomeArticles(pageIndex: Int): List<Article> =
        apiService.getHomeArticles(pageIndex).data.datas

}