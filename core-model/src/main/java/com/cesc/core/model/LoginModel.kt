package com.cesc.core.model


data class LoginInBean(
    val email: String? = "",
    val icon: String? = "",
    val id: Int = 0,
    val password: String? = "",
    val token: String? = "",
    val type: Int = 0,
    val username: String? = "",
    val collectIds: List<Int>? = emptyList()
) : java.io.Serializable

