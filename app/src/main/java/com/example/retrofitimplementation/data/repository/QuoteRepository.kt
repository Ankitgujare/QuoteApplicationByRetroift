package com.example.retrofitimplementation.data.repository

import com.example.retrofitimplementation.data.dto.Quote
import com.example.retrofitimplementation.data.remote.Retrofitinstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object QuoteRepository {
    private var cachedQuotes: List<Quote> = emptyList()
    
    suspend fun getQuotes(): List<Quote> {
        return withContext(Dispatchers.IO) {
            try {
                val response = Retrofitinstance.api.getQuotes()
                if (response.isSuccessful) {
                    cachedQuotes = response.body()?.quotes ?: emptyList()
                    cachedQuotes
                } else {
                    cachedQuotes
                }
            } catch (e: Exception) {
                e.printStackTrace()
                cachedQuotes
            }
        }
    }
    
    fun getCachedQuotes(): List<Quote> = cachedQuotes
}