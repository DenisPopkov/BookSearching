package ru.popkov.data.net.repository

import retrofit2.Retrofit
import ru.popkov.data.net.services.BookService
import ru.popkov.domain.model.BookResponse
import ru.popkov.domain.net.BookNetRepository

class BookRepository(retrofit: Retrofit) : BookNetRepository {
    private val service by lazy { retrofit.create(BookService::class.java) }

    override suspend fun getBooks(
        query: String,
    ): BookResponse {

        return service.getBooks(query)
    }
}