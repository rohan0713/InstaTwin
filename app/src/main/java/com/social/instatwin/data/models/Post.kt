package com.social.instatwin.data.models

data class Post(
    val caption: String,
    val comments: List<Comment>,
    val likes: Int,
    val location: String,
    val postImg: String,
    val userImg: String,
    val username: String
)