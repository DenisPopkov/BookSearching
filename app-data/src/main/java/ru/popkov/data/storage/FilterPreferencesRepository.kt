package ru.popkov.data.storage

import ru.popkov.domain.storage.PreferencesFilter

class FilterPreferencesRepository(private val filterPreferences: FilterPreferences): PreferencesFilter {
    override fun setFilterParameter(filter: String) = filterPreferences.set(filter)
    override fun getFilterParameter() = filterPreferences.get()
}
