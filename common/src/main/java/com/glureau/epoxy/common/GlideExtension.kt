package com.glureau.epoxy.common

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadUrlInto(imageUrl: String?, @DrawableRes placeholder: Int) {
    Glide.with(context)
        .load(imageUrl)
        .centerCrop()
        .apply(
            RequestOptions()
                .override(
                    com.bumptech.glide.request.target.Target.SIZE_ORIGINAL,
                    com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
                )
                .placeholder(placeholder)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
        )
        //.transition(DrawableTransitionOptions.withCrossFade(300))
        .into(this)
}