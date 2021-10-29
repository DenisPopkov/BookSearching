package ru.popkov.booksearch.di

import com.google.gson.Gson
import org.koin.core.module.Module
import org.koin.dsl.module
import ru.popkov.booksearch.di.data.provideNet
import ru.popkov.booksearch.di.data.providePrefs
import ru.popkov.data.storage.FilterPreferences

fun provideData() = module {
    single { Gson() }
    provideNet()
    providePrefs()
}