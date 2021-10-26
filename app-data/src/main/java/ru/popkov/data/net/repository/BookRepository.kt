package ru.popkov.data.net.repository

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import ru.popkov.data.net.services.BookService
import ru.popkov.domain.model.BookResponse
import ru.popkov.domain.model.Item
import ru.popkov.domain.net.BookNetRepository

class BookRepository(retrofit: Retrofit): BookNetRepository {
    private val service by lazy { retrofit.create(BookService::class.java) }

    override suspend fun getAllBooks(q: String?): BookResponse {
        val books = arrayListOf<Item>()
        service.getAllBooks(q).enqueue(object :
            Callback<BookResponse> {
            override fun onResponse(call: Call<BookResponse>, response: Response<BookResponse>) {
                if (response.isSuccessful) {
                    for (book in response.body()?.items!!) {
                        books.add(book)
                        Log.d("efefe", "error - ${book.volumeInfo?.title}")
                    }
                }
            }

            override fun onFailure(call: Call<BookResponse>, t: Throwable) {
                Log.d("efefe", "error - $t")
            }
        })

        return BookResponse(books)
    }

    override suspend fun getBooksByAuthor(author: String): BookResponse {
        val books = arrayListOf<Item>()
        service.getBooksByAuthor(author).enqueue(object :
            Callback<BookResponse> {
            override fun onResponse(call: Call<BookResponse>, response: Response<BookResponse>) {
                if (response.isSuccessful) {
                    for (book in response.body()?.items!!) {
                        books.add(book)
                    }
                }
            }

            override fun onFailure(call: Call<BookResponse>, t: Throwable) {
                Log.d("efefe", "error - $t")
            }
        })

        return BookResponse(books)
    }

    override suspend fun getBooks(title: String): BookResponse {
        val books = arrayListOf<Item>()
        service.getBooks(title).enqueue(object :
            Callback<BookResponse> {
            override fun onResponse(call: Call<BookResponse>, response: Response<BookResponse>) {
                if (response.isSuccessful) {
                    for (book in response.body()?.items!!) {
                        books.add(book)
                    }
                }
            }

            override fun onFailure(call: Call<BookResponse>, t: Throwable) {
                Log.d("efefe", "error - $t")
            }
        })

        return BookResponse(books)
    }

    override suspend fun getBooksGenre(genre: String): BookResponse {
        val books = arrayListOf<Item>()
        service.getBooksGenre(genre).enqueue(object :
            Callback<BookResponse> {
            override fun onResponse(call: Call<BookResponse>, response: Response<BookResponse>) {
                if (response.isSuccessful) {
                    for (book in response.body()?.items!!) {
                        books.add(book)
                    }
                }
            }

            override fun onFailure(call: Call<BookResponse>, t: Throwable) {
                Log.d("efefe", "error - $t")
            }
        })

        return BookResponse(books)
    }

    override suspend fun getBooksPublisher(publisher: String): BookResponse {
        val books = arrayListOf<Item>()
        service.getBooksPublisher(publisher).enqueue(object :
            Callback<BookResponse> {
            override fun onResponse(call: Call<BookResponse>, response: Response<BookResponse>) {
                if (response.isSuccessful) {
                    for (book in response.body()?.items!!) {
                        books.add(book)
                    }
                }
            }

            override fun onFailure(call: Call<BookResponse>, t: Throwable) {
                Log.d("efefe", "error - $t")
            }
        })

        return BookResponse(books)
    }
}