package com.example.presentation.views.photo

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("originImageUrl")
fun loadImage(view: ImageView, url: String?) {
    url?.let {
        view.load(it) {
            crossfade(true)
            placeholder(android.R.drawable.progress_indeterminate_horizontal)
            error(android.R.drawable.stat_notify_error)
        }
    }
}

@BindingAdapter("originThumbUrl")
fun loadThumbImage(view: ImageView, url: String?) {
    url?.let {
        view.load(it) {
            crossfade(true)
            placeholder(android.R.drawable.progress_indeterminate_horizontal)
            error(android.R.drawable.stat_notify_error)
        }
    }
}