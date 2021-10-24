package ru.popkov.booksearch.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import ru.popkov.data.net.retrofit.LoggingInterceptorFactory
import ru.popkov.data.net.retrofit.RetrofitFactory
import ru.popkov.data.net.retrofit.ServerErrorInterceptor
import ru.popkov.domain.interactors.BookInteractor
import ru.popkov.domain.net.BookNetRepository
import javax.inject.Singleton

fun provideDomain() = module {
    provideInteractors()
}

private fun org.koin.core.module.Module.provideInteractors() {
    single<BookNetRepository> { BookInteractor(get()) }
}

private fun org.koin.core.module.Module.provideInterceptors() {
    single { LoggingInterceptorFactory.create() }
    single { ServerErrorInterceptor() }
}

private fun org.koin.core.module.Module.provideRetrofit() {
    single {
        val logs = get<HttpLoggingInterceptor>()
        val errors = get<ServerErrorInterceptor>()
        RetrofitFactory.create(get(), "https://www.googleapis.com/books/v1/", logs, errors)
    }
}