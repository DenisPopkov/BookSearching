package ru.popkov.data.storage.base

import android.content.SharedPreferences

abstract class BasePreferences(
    private val preferences: SharedPreferences,
    private val key: String
) {
    fun getValue() = preferences.getString(key, "")
    fun get() = preferences.getString(key, null)
    fun set(value: String) = preferences.edit().putString(key, value).apply()
}
