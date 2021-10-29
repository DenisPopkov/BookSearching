package ru.popkov.domain.interactors

import ru.popkov.domain.storage.IPreference
import ru.popkov.domain.storage.PreferencesFilter

class PreferencesInteractor(private val repo: PreferencesFilter): IPreference {
    override fun createPreferencesFile(filter: String) = repo.createPreferencesFile(filter)

    override fun getFilterParameter(filter: String) = repo.getFilterParameter(filter)
}