package com.ezper.advweek4160421030.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.DefaultRetryPolicy
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
        loadingLD.value = true
        movieLoadErrorLD.value = false
        Log.d("CEKMASUK", "masukvolley")
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/movies/movies.json"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                val mType = object : TypeToken<List<Movie>>() {}.type
                val result = Gson().fromJson<List<Movie>>(response, mType)
                moviesLD.value = result as ArrayList<Movie>?
                Log.d("showvoley", result.toString())
            },
            { error ->
                Log.e("showvoley", "Error fetching data: ${error.message}")
                Log.e("showvoley", "Error fetching data", error)
                loadingLD.value = false
            }
        )

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }

}