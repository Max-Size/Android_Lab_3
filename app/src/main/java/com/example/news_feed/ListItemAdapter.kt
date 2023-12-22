package com.example.news_feed

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ListItemAdapter(private val dataSet: List<News>, private val context: Context) :
    RecyclerView.Adapter<ListItemAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView
        val description: TextView
        val image: ImageView
        init {
            title = view.findViewById(R.id.title)
            description = view.findViewById(R.id.description)
            image = view.findViewById(R.id.image)
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_item, viewGroup, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val listItem = dataSet[position]
        if (position == dataSet.size-2 && MainActivityModel.nextPage != null) MainActivityModel.goNextPage(this)
        if (listItem.imageUrl != null) Picasso.get().load(Uri.parse(listItem.imageUrl)).into(viewHolder.image)
        viewHolder.title.text = listItem.title
        viewHolder.description.text = listItem.description

        viewHolder.itemView.setOnClickListener{
            val intent = Intent(context, NewDetailsActivity::class.java)
            intent.putExtra("newsObjIndex",position)
            startActivity(context,intent,null)
        }

    }

    override fun getItemCount() = dataSet.size

}