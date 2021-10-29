package ru.popkov.booksearch.di.data

import android.preference.PreferenceManager
import org.koin.core.module.Module
import ru.popkov.data.storage.FilterPreferences
import ru.popkov.data.storage.FilterPreferencesRepository
import ru.popkov.domain.storage.PreferencesFilter

fun Module.providePrefs() {
    single { PreferenceManager.getDefaultSharedPreferences(get()) }
    providePreferencesRepository()
}

fun Module.providePreferencesRepository() {
    single { FilterPreferences(get()) }

    single<PreferencesFilter> { FilterPreferencesRepository(get()) }
}