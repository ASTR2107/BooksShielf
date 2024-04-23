package com.example.bookshielf.network


import com.example.boockSheilf.BoockShielf
import retrofit2.http.GET
import retrofit2.http.Query

 interface BooksService {
    @GET("volumes")
    suspend fun bookSearch(
        @Query("q") searchQuery: String,
        @Query("maxResults") maxResults: Int
    ): BoockShielf

}