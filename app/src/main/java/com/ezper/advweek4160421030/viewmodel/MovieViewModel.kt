package com.ezper.advweek4160421030.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.ezper.advweek4160421030.model.Movie
import com.ezper.advweek4160421030.model.Student
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MovieViewModel(application: Application):AndroidViewModel(application) {
    val moviesLD = MutableLiveData<ArrayList<Movie>>()
    val loadingLD = MutableLiveData<Boolean>()
    val movieLoadErrorLD = MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue:RequestQueue ?= null

    fun refresh() {
        Log.d("CEKMASUK", "masukvolley")
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.12.162.236/movies/movies.json"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<List<Movie>>() {}.type
                val result = Gson().fromJson<List<Student>>(it, sType)
                moviesLD.value = result as ArrayList<Movie>
                Log.d("showvolley", result.toString())
            },
            {
                Log.d("showvolley", it.toString())
            }
        )

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}