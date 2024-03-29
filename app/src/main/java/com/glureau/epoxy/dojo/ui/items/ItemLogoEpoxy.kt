package com.glureau.epoxy.dojo.ui.items

import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.glureau.epoxy.common.KotlinEpoxyHolder
import com.glureau.epoxy.dojo.R

@EpoxyModelClass
abstract class ItemLogoEpoxy : EpoxyModelWithHolder<ItemLogoEpoxy.Holder>() {
    override fun getDefaultLayout() = R.layout.item_logo
    class Holder : KotlinEpoxyHolder()
}