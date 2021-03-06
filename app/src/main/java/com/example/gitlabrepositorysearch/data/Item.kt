package com.example.gitlabrepositorysearch.data

data class Item(
    val html_url: String,
    val url: String,
    val owner: Owner,
    val full_name: String,
    val name: String,
    val description: String,
    val size: Int

)
data class Owner(
    val avatar_url: String,
    val login: String
)