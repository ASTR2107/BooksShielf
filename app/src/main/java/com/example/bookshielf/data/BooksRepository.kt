package com.example.bookshielf.data

import com.example.bookshielf.network.BooksService

interface BooksRepository {
    suspend fun getBooks(query: String, maxResults: Int) : List<Book>
}

open class NetworkBooksRepository(
    private val booksService: BooksService
) : BooksRepository{
    override suspend fun getBooks(query: String, maxResults: Int
    ): List<Book> = booksService.bookSearch(query,maxResults).items.map {
        items -> Book(
            title = items.volumeInfo?.title,
            previewLink = items.volumeInfo?.previewLink,
            imageLink = items.volumeInfo?.imageLinks?.thumbnail
        )
    }

    }
