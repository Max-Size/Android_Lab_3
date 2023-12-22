package com.example.news_feed


import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object MainActivityModel {

    var lastQuery: String? = null
    var nextPage: String? = null
    var newsList: MutableList<News> = mutableListOf()
    private val apiKey = "pub_35218d3fa074aac48073c0a938de2bdf7eb75"

    fun getNews(query: String,recyclerView: RecyclerView){
        GlobalScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO) {
                val service = Client().getClient()
                val response = service.getLatestNews(apiKey, query).execute()
                val body = response.body()
                lastQuery = query
                nextPage = body?.nextPage
                newsList.clear()
                newsList.addAll(body?.results as Collection<News>)
            }
            recyclerView.adapter?.notifyDataSetChanged()
        }
    }

    fun goNextPage(adapter: ListItemAdapter){
        GlobalScope.launch(Dispatchers.Main) {
            val positionStart = newsList.size - 1
            val itemsAdded: Int?
            withContext(Dispatchers.IO) {
                val service = Client().getClient()
                val response = nextPage?.let { lastQuery?.let { it1 ->
                    service.goNextPage(apiKey,
                        it1,it)
                } }?.execute()
                val body = response?.body()
                itemsAdded = body?.results?.size
                nextPage = body?.nextPage
                newsList.addAll(body?.results as Collection<News>)
            }
            if (itemsAdded != null) {
                adapter.notifyItemRangeInserted(positionStart, itemsAdded)
            }
        }
    }

}