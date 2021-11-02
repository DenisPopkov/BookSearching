package ru.popkov.booksearch.di

import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import ru.popkov.data.net.retrofit.LoggingInterceptorFactory
import ru.popkov.data.net.retrofit.RetrofitFactory
import ru.popkov.data.net.retrofit.ServerErrorInterceptor
import ru.popkov.domain.interactors.BookInteractor
import ru.popkov.domain.interactors.FilterInteractor
import ru.popkov.domain.storage.IFilterInteractor

private const val BASE_URL = "https://www.googleapis.com/books/v1/"

fun provideDomain() = module {
    provideInteractors()
    provideInterceptors()
    provideRetrofit()
}

private fun org.koin.core.module.Module.provideInteractors() {
    single { BookInteractor(get()) }
}

private fun org.koin.core.module.Module.provideInterceptors() {
    single { LoggingInterceptorFactory.create() }
    single { ServerErrorInterceptor() }
    single<IFilterInteractor> { FilterInteractor(get()) }
}

private fun org.koin.core.module.Module.provideRetrofit() {
    single {
        val logs = get<HttpLoggingInterceptor>()
        val errors = get<ServerErrorInterceptor>()
        RetrofitFactory.create(get(), BASE_URL, logs, errors)
    }
}
