package ru.popkov.domain.interactors

import ru.popkov.domain.model.BookResponse
import ru.popkov.domain.net.BookNetRepository

class BookInteractor(private val repository: BookNetRepository) {

    suspend fun getBooks(
        query: String
    ): BookResponse = repository.getBooks(query)
}