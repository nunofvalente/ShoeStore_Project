package com.udacity.shoestore.databinding

import android.content.Context
import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.udacity.shoestore.R

class GlideBindingAdapter {

  /*  @BindingAdapter("imageUrl")
    public static void setImageResource(ImageView view, String imageUrl) {
        Context context = view.getContext();

        /*    RequestOptions options = new RequestOptions()
                     .dontAnimate()
                     .placeholder(R.drawable.default_account)
                     .error(R.drawable.default_account);*/

        GlideApp.with(context)
            .load(imageUrl)
            .placeholder(R.drawable.default_account)
            .into(view);
    }*/

    @BindingAdapter("imageUrl")
    fun setImageResource(imageView: ImageView, imageUrl: String) {
        val context = imageView.context

        Glide.with(context).load(Uri.parse(imageUrl)).placeholder(R.drawable.default_image).into(imageView)
    }
}