package com.example.news_feed

class NewsResponse(
    val status: String,
    val totalResults: Int,
    val results: List<News>,
    val nextPage: String
)