package ru.popkov.domain.storage

import android.content.Context

interface PreferencesFilter {

    fun get(context: Context): String
    fun set(context: Context, parameter: String)
}