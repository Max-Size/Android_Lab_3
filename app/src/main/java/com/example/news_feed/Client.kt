package com.example.news_feed

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Client {
    private val BASE_URL = "https://newsdata.io/api/1/"
    fun getClient(): RetrofitService {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        return retrofit.create(RetrofitService::class.java)
    }
}