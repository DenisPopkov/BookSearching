package ru.popkov.domain.storage

interface PreferencesFilter {

    fun setFilterParameter(filter: String)
    fun getFilterParameter(): String?
}
