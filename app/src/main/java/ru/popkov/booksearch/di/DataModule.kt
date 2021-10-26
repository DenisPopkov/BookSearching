package ru.popkov.booksearch.di

import com.google.gson.Gson
import org.koin.dsl.module
import ru.popkov.booksearch.di.data.provideNet

fun provideData() = module {
    single { Gson() }
    provideNet()
}