package com.glureau.epoxy.dojo.items

import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.betclic.epoxy.KotlinEpoxyHolder
import com.glureau.epoxy.dojo.R

@EpoxyModelClass
abstract class ItemFooterEpoxy : EpoxyModelWithHolder<ItemFooterEpoxy.Holder>() {
    override fun getDefaultLayout() = R.layout.item_footer
    class Holder : KotlinEpoxyHolder() {
    }
}