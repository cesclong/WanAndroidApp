package com.cesc.core.data.network

import com.cesc.core.model.HomeBanner
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.core.annotation.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

internal interface WanAndroidApiService {
    @GET("banner/json")
    suspend fun getHomeBanner(): NetworkResponse<List<HomeBanner>>

}

data class NetworkResponse<T>(
    val data: T,
) : java.io.Serializable


@Singleton
class RetrofitNetwork : WanAndroidNetwork {
    private val apiService = Retrofit.Builder()
        .client(
            OkHttpClient
                .Builder()
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
}