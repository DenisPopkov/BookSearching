package ru.popkov.domain.storage

interface PreferencesFilter {

    fun createPreferencesFile(filter: String)
    fun getFilterParameter(): String?
}