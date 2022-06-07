package com.cesc.core.data.network

import com.cesc.core.data.datasource.PreferenceStore
import com.tencent.mmkv.MMKV
import okhttp3.Interceptor
import okhttp3.Response
import org.koin.core.annotation.Named
import org.koin.core.annotation.Singleton


interface RetrofitInterceptor : Interceptor


@Singleton
@Named("cookieSaver")
class ReceivedCookieInterceptor(
    @Named("mmkv") private val localStore: PreferenceStore
) : RetrofitInterceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        val requestUrl = request.url.toString()
        if (response.headers(HttpConstants.COOKIE_NAME).isNotEmpty()
            && requestUrl.contains(HttpConstants.SAVE_USER_LOGIN_KEY)
            || requestUrl.contains(HttpConstants.SAVE_USER_REGISTER_KEY)
        ) {
            val cookieSet = mutableSetOf<String>()
            val cookies = response.headers(HttpConstants.COOKIE_NAME)
            for (cookie in cookies) {
                cookieSet.add(cookie)
            }

            localStore.saveStringSet(HttpConstants.COOKIE_KEY, cookieSet)
        }

        return response
    }

}


