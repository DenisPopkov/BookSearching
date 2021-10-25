package ru.popkov.data.net.repository

import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import ru.popkov.domain.model.BookModel
import ru.popkov.data.net.services.BookService
import ru.popkov.domain.net.BookNetRepository

class BookRepository(retrofit: Retrofit): BookNetRepository {
    private val service by lazy { retrofit.create(BookService::class.java) }

    override suspend fun getAllBooks(q: String?): List<BookModel> =
        service.getAllBooks(q)
}