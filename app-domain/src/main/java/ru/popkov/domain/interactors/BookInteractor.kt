package ru.popkov.domain.interactors

import ru.popkov.domain.model.BookResponse
import ru.popkov.domain.net.BookNetRepository

class BookInteractor(private val bookNetRepository: BookNetRepository): BookNetRepository {

    override suspend fun getAllBooks(q: String?): BookResponse {
        return bookNetRepository.getAllBooks(q)
    }

    override suspend fun getBooksByAuthor(author: String): BookResponse {
        return bookNetRepository.getBooksByAuthor(author)
    }

    override suspend fun getBooks(title: String): BookResponse {
        return bookNetRepository.getBooks(title)
    }

    override suspend fun getBooksGenre(genre: String): BookResponse {
        return bookNetRepository.getBooksGenre(genre)
    }

    override suspend fun getBooksPublisher(publisher: String): BookResponse {
        return bookNetRepository.getBooksPublisher(publisher)
    }
}