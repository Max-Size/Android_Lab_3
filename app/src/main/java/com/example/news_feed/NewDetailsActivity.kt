package com.example.news_feed

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class NewDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_details)

        val newsIndex = intent.getIntExtra("newsObjIndex", 0)
        val newsObj = MainActivityModel.newsList[newsIndex]

        findViewById<TextView>(R.id.content).text = newsObj.content
        findViewById<TextView>(R.id.details_title).text = newsObj.title
        findViewById<TextView>(R.id.date).text = newsObj.pubDate
        if (newsObj.imageUrl != null) Picasso.get().load(Uri.parse(newsObj.imageUrl)).into(findViewById<ImageView>(R.id.details_image))

    }
}