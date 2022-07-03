package com.example.gitlabrepositorysearch.application

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.gitlabrepositorysearch.R

class DetailScreen : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_screeen)
        // Get the Intent that started this activity and extract the string
        val title = intent.getStringExtra("title")
        val owner = intent.getStringExtra("owner")
        val url = intent.getStringExtra("url")
        val description = intent.getStringExtra("description")

        // Capture the layout's TextView and set the string as its text
        val tvTitle = findViewById<TextView>(R.id.tvTitle).apply {
            text = "Title: $title"
        }
        val tvOwner = findViewById<TextView>(R.id.tvOwner).apply {
            text = "Owner: $owner"
        }
        val tvDescription = findViewById<TextView>(R.id.tvDescription).apply {
            text = "Description: $description"
        }
        val tvUrl = findViewById<TextView>(R.id.tvUrl).apply {
            text = url

        }
        tvUrl.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            ContextCompat.startActivity(this, intent, null)
        }
    }
}
