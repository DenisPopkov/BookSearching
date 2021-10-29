package ru.popkov.domain.storage

interface IPreference {

    fun createPreferencesFile(filter: String)
    fun getFilterParameter(filter: String): String?
}