package com.example.news_feed

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("news")
    fun getLatestNews(@Query("apikey") apiKey: String, @Query("q") query: String): Call<NewsResponse>

    @GET("news")
    fun goNextPage(@Query("apikey") apiKey: String,@Query("q") query: String ,@Query("page") nextPage: String): Call<NewsResponse>
}