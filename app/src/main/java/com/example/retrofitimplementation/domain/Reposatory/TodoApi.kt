package com.example.retrofitimplementation.domain.repository

import com.example.retrofitimplementation.data.dto.Quotes
import retrofit2.Response
import retrofit2.http.GET

interface TodoApi {

    @GET("/quotes")
    suspend fun getQuotes(): Response<Quotes>
}