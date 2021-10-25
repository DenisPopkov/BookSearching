package ru.popkov.data.net.services

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query
import ru.popkov.domain.model.BookModel

interface BookService {
    @GET("volumes/")
    suspend fun getAllBooks(@Query("q") q: String?): List<BookModel>
}