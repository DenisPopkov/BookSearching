package ru.popkov.booksearch.di

import com.google.gson.Gson
import org.koin.dsl.module
import ru.popkov.data.net.repository.BookRepository
import ru.popkov.domain.net.BookNetRepository

fun provideData() = module {
    single { Gson() }
}

private fun org.koin.core.module.Module.provideApartmentCardRepository() {
    single<BookNetRepository> {
        BookRepository(get())
    }
}