package com.glureau.epoxy.dojo.items

import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.betclic.epoxy.KotlinEpoxyHolder
import com.glureau.epoxy.dojo.R

@EpoxyModelClass
abstract class ItemHeaderEpoxy : EpoxyModelWithHolder<ItemHeaderEpoxy.Holder>() {
    override fun getDefaultLayout() = R.layout.item_header
    class Holder : KotlinEpoxyHolder() {
    }
}