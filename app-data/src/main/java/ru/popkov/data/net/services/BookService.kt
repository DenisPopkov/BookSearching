package ru.popkov.data.net.services

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.popkov.domain.model.BookResponse

interface BookService {
    //Default filter
    @GET("volumes")
    suspend fun getAllBooks(@Query("q") q: String?): Call<BookResponse>

    //Filter by author
    @GET("volumes?q=inauthor:{author}")
    suspend fun getBooksByAuthor(
        @Path("author") author: String): Call<BookResponse>

    //Filter by name
    @GET("volumes?q={title}")
    suspend fun getBooks(@Path("title") title: String): Call<BookResponse>

    //Filter by genre
    @GET("volumes?q=subject:{genre}")
    suspend fun getBooksGenre(@Path("genre") genre: String): Call<BookResponse>

    //Filter by publisher
    @GET("volumes?q=inpublisher:{publisher}")
    suspend fun getBooksPublisher(@Path("publisher") publisher: String): Call<BookResponse>
}