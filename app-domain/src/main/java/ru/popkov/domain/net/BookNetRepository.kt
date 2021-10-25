package ru.popkov.domain.net

import kotlinx.coroutines.Deferred
import ru.popkov.domain.model.BookModel

interface BookNetRepository {
    suspend fun getAllBooks(q: String?): List<BookModel>
}