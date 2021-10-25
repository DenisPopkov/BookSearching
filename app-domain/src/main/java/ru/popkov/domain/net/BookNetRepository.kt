package ru.popkov.domain.net

import kotlinx.coroutines.Deferred
import ru.popkov.domain.model.BookModel

interface BookNetRepository {
    suspend fun getAllBooks(q: String?): List<BookModel>
    suspend fun getBooksByAuthor(author: String): List<BookModel>
    suspend fun getBooks(title: String): List<BookModel>
    suspend fun getBooksGenre(genre: String): List<BookModel>
    suspend fun getBooksPublisher(publisher: String): List<BookModel>
}