package ru.popkov.booksearch.di

import android.content.Context
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.koin.dsl.module
import ru.popkov.data.net.retrofit.RetrofitFactory
import ru.popkov.data.net.services.BookService
import javax.inject.Singleton

fun provideData() = module {
    single { Gson() }
}