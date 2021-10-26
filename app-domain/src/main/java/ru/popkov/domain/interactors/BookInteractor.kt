package ru.popkov.domain.interactors

import ru.popkov.domain.interfaces.IBookInteractor
import ru.popkov.domain.model.BookResponse
import ru.popkov.domain.net.BookNetRepository

class BookInteractor(private val repository: BookNetRepository) {

    suspend fun getAllBooks(q: String?) = repository.getAllBooks(q)

    suspend fun getBooksByAuthor(author: String) = repository.getBooksByAuthor(author)

    suspend fun getBooks(title: String) = repository.getBooks(title)

    suspend fun getBooksGenre(genre: String) = repository.getBooksGenre(genre)

    suspend fun getBooksPublisher(publisher: String) = repository.getBooksPublisher(publisher)
}