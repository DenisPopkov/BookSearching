package ru.popkov.ui.common.storage

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

fun createPreferencesFile(context: Context, param: String) {
    val preference = context.getSharedPreferences("filter", Context.MODE_PRIVATE)
    preference.edit().putString("parameter", param).apply()
}

fun getFilterParameter(context: Context): String {
    val preference = context.getSharedPreferences("filter", Context.MODE_PRIVATE)
    return preference.getString("parameter", "").toString()
}