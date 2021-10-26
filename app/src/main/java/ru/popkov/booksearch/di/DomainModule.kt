package ru.popkov.booksearch.di

import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import ru.popkov.data.net.retrofit.LoggingInterceptorFactory
import ru.popkov.data.net.retrofit.RetrofitFactory
import ru.popkov.data.net.retrofit.ServerErrorInterceptor
import ru.popkov.domain.interactors.BookInteractor
import ru.popkov.domain.interfaces.IBookInteractor
import ru.popkov.domain.net.BookNetRepository

private const val BASE_URL = "https://www.googleapis.com/books/v1/"

fun provideDomain() = module {
    provideInteractors()
    provideInterceptors()
    provideRetrofit()
}

private fun org.koin.core.module.Module.provideInteractors() {
    single<IBookInteractor> { BookInteractor(get()) }
}

private fun org.koin.core.module.Module.provideInterceptors() {
    single { LoggingInterceptorFactory.create() }
    single { ServerErrorInterceptor() }
}

private fun org.koin.core.module.Module.provideRetrofit() {
    single {
        val logs = get<HttpLoggingInterceptor>()
        val errors = get<ServerErrorInterceptor>()
        RetrofitFactory.create(get(), BASE_URL, logs, errors)
    }
}