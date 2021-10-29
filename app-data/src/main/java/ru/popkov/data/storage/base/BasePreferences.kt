package ru.popkov.data.storage.base

import android.content.SharedPreferences

abstract class BasePreferences(
    private val preferences: SharedPreferences,
    private val key: String
) {
    fun getValue(defaultValue: String) = preferences.getString(key, defaultValue)
    fun set(value: String) = preferences.edit().putString(key, value).apply()
}