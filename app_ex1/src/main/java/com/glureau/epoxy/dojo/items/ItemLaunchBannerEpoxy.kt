package com.glureau.epoxy.dojo.items

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.betclic.epoxy.KotlinEpoxyHolder
import com.glureau.epoxy.dojo.R
import com.glureau.epoxy.dojo.common.loadUrlInto

@EpoxyModelClass
abstract class ItemLaunchBannerEpoxy : EpoxyModelWithHolder<ItemLaunchBannerEpoxy.Holder>() {
    override fun getDefaultLayout() = R.layout.item_banner

    @EpoxyAttribute
    var title: String? = null
    @EpoxyAttribute
    var subTitle: String? = null
    @EpoxyAttribute
    var pictureUrl: String? = null
    @EpoxyAttribute
    var onItemClicked: View.OnClickListener? = null

    override fun bind(holder: Holder) {
        super.bind(holder)
        holder.title.text = title
        holder.subTitle.text = subTitle
        holder.imageView.loadUrlInto(pictureUrl)
        holder.container.setOnClickListener(onItemClicked)
    }

    class Holder : KotlinEpoxyHolder() {
        val container by bind<ViewGroup>(R.id.itemHeaderContainer)
        val title by bind<TextView>(R.id.itemHeaderTitle)
        val subTitle by bind<TextView>(R.id.itemHeaderSubTitle)
        val imageView by bind<ImageView>(R.id.itemHeaderImageView)
    }
}