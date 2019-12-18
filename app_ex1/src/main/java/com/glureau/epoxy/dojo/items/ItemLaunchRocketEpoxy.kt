package com.glureau.epoxy.dojo.items

import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.betclic.epoxy.KotlinEpoxyHolder
import com.glureau.epoxy.dojo.R

@EpoxyModelClass
abstract class ItemLaunchRocketEpoxy : EpoxyModelWithHolder<ItemLaunchRocketEpoxy.Holder>() {
    override fun getDefaultLayout() = R.layout.item_rocket

    @EpoxyAttribute
    var rocketId: String? = null
    @EpoxyAttribute
    var rocketType: String? = null
    @EpoxyAttribute
    var rocketName: String? = null

    override fun bind(holder: Holder) {
        super.bind(holder)
        holder.rocketId.text = rocketId
        holder.rocketName.text = rocketName
        holder.rocketType.text = rocketType
    }

    class Holder : KotlinEpoxyHolder() {
        val rocketId by bind<TextView>(R.id.itemRocketId)
        val rocketName by bind<TextView>(R.id.itemRocketName)
        val rocketType by bind<TextView>(R.id.itemRocketType)
    }
}