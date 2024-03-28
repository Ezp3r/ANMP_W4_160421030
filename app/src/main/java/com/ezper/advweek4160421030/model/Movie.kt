package com.ezper.advweek4160421030.model

data class Movie(
    val title:String,
    val genre:String,
    val director:Director,
    val releaseYear:Int,
    val rating:Int,
    val cast: List<String>,
    val plot: String
)