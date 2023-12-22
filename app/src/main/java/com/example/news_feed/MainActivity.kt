package com.example.news_feed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val searchButton: Button = findViewById(R.id.searching_button)
        val editText: EditText = findViewById(R.id.edit_query)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ListItemAdapter(MainActivityModel.newsList, this)
        recyclerView.adapter = adapter

        searchButton.setOnClickListener{
            MainActivityModel.getNews(editText.text.toString(),recyclerView)
        }


    }
}