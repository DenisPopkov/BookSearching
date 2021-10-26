package ru.popkov.booksearch.di.data

import org.koin.core.module.Module
import ru.popkov.data.net.repository.BookRepository
import ru.popkov.domain.net.BookNetRepository

fun Module.provideNet() {
    provideRepositories()
}

private fun Module.provideRepositories() {
    provideApartmentCardRepository()
}

private fun Module.provideApartmentCardRepository() {
    single<BookNetRepository> {
        BookRepository(get())
    }
}