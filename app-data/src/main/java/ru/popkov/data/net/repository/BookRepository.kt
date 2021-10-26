package ru.popkov.data.net.repository

import retrofit2.Retrofit
import ru.popkov.data.net.services.BookService
import ru.popkov.domain.model.BookResponse
import ru.popkov.domain.net.BookNetRepository

class BookRepository(retrofit: Retrofit): BookNetRepository {
    private val service by lazy { retrofit.create(BookService::class.java) }

    override suspend fun getAllBooks(q: String?): BookResponse = service.getAllBooks(q)

    override suspend fun getBooksByAuthor(author: String): BookResponse = service.getBooksByAuthor(author)

    override suspend fun getBooks(title: String): BookResponse = service.getBooks(title)

    override suspend fun getBooksGenre(genre: String): BookResponse = service.getBooksGenre(genre)

    override suspend fun getBooksPublisher(publisher: String): BookResponse = service.getBooksPublisher(publisher)
}