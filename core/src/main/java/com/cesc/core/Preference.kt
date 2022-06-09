package com.cesc.core

import com.tencent.mmkv.MMKV
import kotlin.reflect.KProperty

class Preference<T>(private val name: String, private val defaultValue: T) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        val res: Any = when (defaultValue) {
            is Long -> MMKV.defaultMMKV().decodeLong(name, defaultValue)
            is String -> MMKV.defaultMMKV().decodeString(name, defaultValue) ?: ""
            is Boolean -> MMKV.defaultMMKV().decodeBool(name, defaultValue)
            else -> MMKV.defaultMMKV().decodeString(name) ?: ""
        }

        return res as T
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        when (value) {
            is Long -> MMKV.defaultMMKV().encode(name, value)
            is String -> MMKV.defaultMMKV().encode(name, value)
            is Boolean -> MMKV.defaultMMKV().encode(name, value)
            else -> {}
        }

    }
}