package com.ezper.advweek4160421030.view

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception
import java.net.URL

@BindingAdapter("android:imageUrl")
fun loadPhotoUrl(imageView: ImageView, url: String?) {
    if (url != null && url.isNotBlank()) {
        val picasso = Picasso.Builder(imageView.context)
        picasso.listener { picasso, uri, exception ->
            exception.printStackTrace()
        }
        picasso.build().load(url).into(imageView, object: Callback {
            override fun onSuccess() {
                imageView.visibility = View.VISIBLE
            }

            override fun onError(e: Exception?) {
                Log.e("picasso_error", e.toString())
            }
        })
    } else {
        // Handle case where URL is null or blank
        // You can set a placeholder image or hide the ImageView
        imageView.visibility = View.GONE
    }
}
