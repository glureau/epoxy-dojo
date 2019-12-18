package com.glureau.epoxy.dojo.common

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.glureau.epoxy.dojo.R
import java.util.*

fun ImageView.loadUrlInto(imageUrl: String?) {
    val defaultPlaceholder = when (Random().nextInt(3)) {
        0 -> R.drawable.spacex1
        1 -> R.drawable.spacex2
        else -> R.drawable.spacex3
    }
    Glide.with(context)
        .load(imageUrl)
        .centerCrop()
        .apply(
            RequestOptions()
                .override(
                    com.bumptech.glide.request.target.Target.SIZE_ORIGINAL,
                    com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
                )
                .placeholder(defaultPlaceholder)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
        )
        //.transition(DrawableTransitionOptions.withCrossFade(300))
        .into(this)
}