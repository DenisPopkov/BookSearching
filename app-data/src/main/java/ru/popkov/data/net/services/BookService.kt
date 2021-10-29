package ru.popkov.data.net.services

import retrofit2.http.GET
import retrofit2.http.Query
import ru.popkov.domain.model.BookResponse

interface BookService {

    @GET("volumes")
    suspend fun getBooks(
        @Query("q") query: String
    ): BookResponse
}