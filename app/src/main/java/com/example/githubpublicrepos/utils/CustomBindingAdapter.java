package com.example.githubpublicrepos.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Binds imageUrl String with Picasso.
 */

public class CustomBindingAdapter {

    @BindingAdapter("bind:imageUrl")
    public static void loadImage(ImageView imageView, String imgUrl) {
        Picasso.with(imageView.getContext()).load(imgUrl).into(imageView);
    }

}