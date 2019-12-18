package com.glureau.epoxy.dojo.items

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.betclic.epoxy.KotlinEpoxyHolder
import com.glureau.epoxy.dojo.R

@EpoxyModelClass
abstract class ItemSeparatorEpoxy : EpoxyModelWithHolder<ItemSeparatorEpoxy.Holder>() {
    override fun getDefaultLayout() = R.layout.item_separator

    @EpoxyAttribute
    var color: Int? = null

    override fun bind(holder: Holder) {
        color?.let { holder.separator.setBackgroundColor(it) }
    }

    class Holder : KotlinEpoxyHolder() {
        val separator: View by bind(R.id.itemSeparator)
    }
}