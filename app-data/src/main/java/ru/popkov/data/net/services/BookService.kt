package ru.popkov.data.net.services

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.popkov.domain.model.BookResponse

interface BookService {

    //Default filter
    @GET("volumes?")
    suspend fun getAllBooks(
        @Query("q") q: String?): BookResponse

    //Filter by author
    @GET("volumes?q=inauthor?")
    suspend fun getBooksByAuthor(
        @Query("author") author: String): BookResponse

    //Filter by name
    @GET("volumes?q=title?")
    suspend fun getBooks(
        @Query("title") title: String): BookResponse

    //Filter by genre
    @GET("volumes?q=subject?")
    suspend fun getBooksGenre(
        @Query("genre") genre: String): BookResponse

    //Filter by publisher
    @GET("volumes?q=inpublisher?")
    suspend fun getBooksPublisher(
        @Query("publisher") publisher: String): BookResponse
}