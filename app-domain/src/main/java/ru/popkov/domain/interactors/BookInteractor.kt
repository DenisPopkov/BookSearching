package ru.popkov.domain.interactors

import ru.popkov.domain.model.BookModel
import ru.popkov.domain.net.BookNetRepository

class BookInteractor(private val bookNetRepository: BookNetRepository): BookNetRepository {

    override suspend fun getAllBooks(q: String?): List<BookModel> {
        return bookNetRepository.getAllBooks(q)
    }

    override suspend fun getBooksByAuthor(author: String): List<BookModel> {
        return bookNetRepository.getBooksByAuthor(author)
    }

    override suspend fun getBooks(title: String): List<BookModel> {
        return bookNetRepository.getBooks(title)
    }

    override suspend fun getBooksGenre(genre: String): List<BookModel> {
        return bookNetRepository.getBooksGenre(genre)
    }

    override suspend fun getBooksPublisher(publisher: String): List<BookModel> {
        return bookNetRepository.getBooksPublisher(publisher)
    }
}