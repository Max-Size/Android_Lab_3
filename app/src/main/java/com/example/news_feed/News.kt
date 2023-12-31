package com.example.news_feed

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class News(
    @SerializedName("image_url")
    val imageUrl: String?,
    val title: String,
    val description: String,
    val content: String,
    val pubDate: String
): Serializable
