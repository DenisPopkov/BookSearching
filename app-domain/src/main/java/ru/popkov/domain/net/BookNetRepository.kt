package ru.popkov.domain.net

import ru.popkov.domain.model.BookResponse

interface BookNetRepository {
    suspend fun getBooks(
        query: String
    ): BookResponse
}