package com.ezper.advweek4160421030.model

data class Movie(
    var title:String?,
    var genre:String?,
    var director:Director?,
    var releaseYear:Int?,
    var rating:Int?,
    var cast: List<String>?,
    var plot: String?
)

data class Director(
    var name: String?,
    var birthYear: Int?,
    var nationality: String?
)