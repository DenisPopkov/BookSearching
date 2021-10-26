package ru.popkov.ui.common.storage

import android.content.Context

fun createPreferenceFilterFile(context: Context, filter: String) {
    val preferences = context.getSharedPreferences("FilterParameter", Context.MODE_PRIVATE)
    preferences.edit().putString("parameter", filter).apply()
}

fun getUserFilterParameter(context: Context): String {
    val preferences = context.getSharedPreferences("FilterParameter", Context.MODE_PRIVATE)
    return preferences.getString("parameter", "").toString()
}