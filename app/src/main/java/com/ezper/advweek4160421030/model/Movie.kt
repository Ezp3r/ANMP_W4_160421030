package com.ezper.advweek4160421030.model

data class Movie(
    val id: Int,
    val title:String,
    val genre:String,
    val director:Director,
    val releaseYear:Int,
    val rating:Double,
    val cast: List<String>,
    val plot: String
)