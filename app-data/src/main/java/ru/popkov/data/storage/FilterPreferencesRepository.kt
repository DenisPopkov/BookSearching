package ru.popkov.data.storage

import ru.popkov.domain.storage.PreferencesFilter

class FilterPreferencesRepository(private val filterPreferences: FilterPreferences): PreferencesFilter {
    override fun createPreferencesFile(filter: String) = filterPreferences.set(filter)
    override fun getFilterParameter(filter: String) = filterPreferences.getValue(filter)
}