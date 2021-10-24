package ru.popkov.domain.interactors

import kotlinx.coroutines.Deferred
import ru.popkov.domain.model.BookModel
import ru.popkov.domain.net.BookNetRepository

class BookInteractor(private val bookNetRepository: BookNetRepository): BookNetRepository {

    override suspend fun getAllBooks(q: String?): Deferred<List<BookModel>> {
        return bookNetRepository.getAllBooks(q)
    }
}