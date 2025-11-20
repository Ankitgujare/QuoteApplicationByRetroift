package com.example.retrofitimplementation.data.remote

import com.example.retrofitimplementation.domain.repository.TodoApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Retrofitinstance {

    val api: TodoApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://dummyjson.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
}