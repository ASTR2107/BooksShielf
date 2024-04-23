package com.example.bookshielf.data

import com.example.bookshielf.network.BooksService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val booksRepository: BooksRepository
}

class DefaultAppContainer : AppContainer{
    val url = "https://www.googleapis.com/books/v1/"
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofitService: BooksService by lazy {retrofit.create(BooksService::class.java)}

    override val booksRepository: BooksRepository by lazy {NetworkBooksRepository(retrofitService)}



}
