package com.cesc.core.data.datasource

import com.cesc.core.data.network.WanAndroidNetwork
import com.cesc.core.model.LoginInBean
import org.koin.core.annotation.Singleton


interface UserLoginDataSource {
    suspend fun login(username: String, password: String): LoginInBean
    suspend fun logout(): Boolean
}


interface UserRegisterDataSource {
    suspend fun register(username: String, password: String, repassword: String)
}


@Singleton
class UserLoginDataSourceImpl(
    private val wanAndroidNetwork: WanAndroidNetwork
) : UserLoginDataSource {
    override suspend fun login(username: String, password: String) =
        wanAndroidNetwork.login(username, password)

    override suspend fun logout() = wanAndroidNetwork.logout()
}

@Singleton
class UserRegisterDataSourceImpl(
    private val wanAndroidNetwork: WanAndroidNetwork
) : UserRegisterDataSource {
    override suspend fun register(username: String, password: String, repassword: String) {
    }

}

