package ru.popkov.data.net.services

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.popkov.domain.model.BookModel

interface BookService {
    //Default filter
    @GET("volumes/")
    suspend fun getAllBooks(@Query("q") q: String?): List<BookModel>

    //Filter by author
    @GET("volumes?q=inauthor:{author}")
    suspend fun getBooksByAuthor(
        @Path("author") author: String): List<BookModel>

    //Filter by name
    @GET("volumes?q={title}")
    suspend fun getBooks(@Path("title") title: String): List<BookModel>

    //Filter by genre
    @GET("volumes?q=subject:{genre}")
    suspend fun getBooksGenre(@Path("genre") genre: String): List<BookModel>

    //Filter by publisher
    @GET("volumes?q=inpublisher:{publisher}")
    suspend fun getBooksPublisher(@Path("publisher") publisher: String): List<BookModel>
}