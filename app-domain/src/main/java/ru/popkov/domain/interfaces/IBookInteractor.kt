package ru.popkov.domain.interfaces

import ru.popkov.domain.model.BookResponse

interface IBookInteractor {
    suspend fun getAllBooks(q: String?): BookResponse
    suspend fun getBooksByAuthor(author: String): BookResponse
    suspend fun getBooks(title: String): BookResponse
    suspend fun getBooksGenre(genre: String): BookResponse
    suspend fun getBooksPublisher(publisher: String): BookResponse
}