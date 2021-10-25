package ru.popkov.data.net.repository

import retrofit2.Retrofit
import ru.popkov.domain.model.BookModel
import ru.popkov.data.net.services.BookService
import ru.popkov.domain.net.BookNetRepository

class BookRepository(retrofit: Retrofit): BookNetRepository {
    private val service by lazy { retrofit.create(BookService::class.java) }

    override suspend fun getAllBooks(q: String?): List<BookModel> =
        service.getAllBooks(q)

    override suspend fun getBooksByAuthor(author: String): List<BookModel> =
        service.getBooksByAuthor(author)

    override suspend fun getBooks(title: String): List<BookModel> =
        service.getBooks(title)

    override suspend fun getBooksGenre(genre: String): List<BookModel> =
        service.getBooksGenre(genre)

    override suspend fun getBooksPublisher(publisher: String): List<BookModel> =
        service.getBooksPublisher(publisher)
}