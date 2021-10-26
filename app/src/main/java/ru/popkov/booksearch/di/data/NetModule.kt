package ru.popkov.booksearch.di.data

import org.koin.core.module.Module
import ru.popkov.data.net.repository.BookRepository
import ru.popkov.domain.net.BookNetRepository

fun Module.provideNet() {
    provideRepositories()
}

private fun Module.provideRepositories() {
    provideBookNetRepository()
}

private fun Module.provideBookNetRepository() {
    single<BookNetRepository> { BookRepository(get()) }
}