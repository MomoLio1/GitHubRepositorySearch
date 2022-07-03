package com.example.gitlabrepositorysearch.adapter

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.gitlabrepositorysearch.R
import com.example.gitlabrepositorysearch.application.DetailScreen
import com.example.gitlabrepositorysearch.application.MainActivity
import com.example.gitlabrepositorysearch.data.Item
import com.squareup.picasso.Picasso


class RepoListAdapter(private val repoList: MutableList<Item>) :
    RecyclerView.Adapter<RepoListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindLayout(data: Item) {
            val title = itemView.findViewById<TextView>(R.id.title)
            val owner = itemView.findViewById<TextView>(R.id.owner)
            val url = itemView.findViewById<TextView>(R.id.url)
            val imageView = itemView.findViewById<ImageView>(R.id.avatarImageView)
            title.text = data.name
            owner.text = data.owner.login
            url.text = data.html_url
            Picasso.with(itemView.context).load(Uri.parse(data.owner.avatar_url)).into(imageView)

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailScreen::class.java)
                    .apply {
                        putExtra("owner", data.owner.login)
                        putExtra("title", data.name)
                        putExtra("url", data.html_url)
                        putExtra("description", data.description)}
                startActivity(itemView.context, intent, null)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recv_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "${repoList[position]}")
        holder.bindLayout(repoList[position])
    }

    override fun getItemCount(): Int {

        return repoList.size
    }


}
