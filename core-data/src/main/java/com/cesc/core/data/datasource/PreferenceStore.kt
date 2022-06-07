package com.cesc.core.data.datasource

import com.tencent.mmkv.MMKV
import org.koin.core.annotation.Named
import org.koin.core.annotation.Singleton


interface PreferenceStore {
    fun saveString(key: String, value: String)
    fun retrieveString(key: String): String

    fun saveBoolean(key: String, value: Boolean)
    fun retrieveBoolean(key: String): Boolean

    fun saveStringSet(key: String, hashSet: MutableSet<String>)
    fun retrieveStringString(key: String): MutableSet<String>
}

@Singleton
@Named("mmkv")
class MMKVPreferenceStoreImpl : PreferenceStore {
    private val mmkv = MMKV.defaultMMKV()

    override fun saveString(key: String, value: String) {
        mmkv.encode(key, value)
    }

    override fun retrieveString(key: String): String = mmkv.decodeString(key, "") ?: ""


    override fun saveBoolean(key: String, value: Boolean) {
        mmkv.encode(key, value)
    }

    override fun retrieveBoolean(key: String): Boolean = mmkv.decodeBool(key, false) ?: false

    override fun saveStringSet(key: String, hashSet: MutableSet<String>) {
        mmkv.encode(key, hashSet)
    }

    override fun retrieveStringString(key: String): MutableSet<String> {
        return mmkv.decodeStringSet(key) ?: mutableSetOf()
    }

}