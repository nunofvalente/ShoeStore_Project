package com.udacity.shoestore.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.udacity.shoestore.R

class GlideBindingAdapter {

    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun setImageResource(imageView: ImageView, imageUrl: String) {
            val context = imageView.context

            Glide.with(context).load(imageUrl).placeholder(R.drawable.default_image)
                .into(imageView)
        }
    }
}