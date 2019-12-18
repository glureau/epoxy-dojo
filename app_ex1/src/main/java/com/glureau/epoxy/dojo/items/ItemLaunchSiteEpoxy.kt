package com.glureau.epoxy.dojo.items

import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.betclic.epoxy.KotlinEpoxyHolder
import com.glureau.epoxy.dojo.R

@EpoxyModelClass
abstract class ItemLaunchSiteEpoxy : EpoxyModelWithHolder<ItemLaunchSiteEpoxy.Holder>() {
    override fun getDefaultLayout() = R.layout.item_launch_site

    @EpoxyAttribute
    var launchSiteId: String? = null
    @EpoxyAttribute
    var launchSiteName: String? = null
    @EpoxyAttribute
    var launchSiteLongName: String? = null

    override fun bind(holder: Holder) {
        super.bind(holder)
        holder.launchSiteId.text = launchSiteId
        holder.launchSiteName.text = launchSiteName
        holder.launchSiteLongName.text = launchSiteLongName
    }

    class Holder : KotlinEpoxyHolder() {
        val launchSiteId by bind<TextView>(R.id.itemLaunchSiteId)
        val launchSiteName by bind<TextView>(R.id.itemLaunchSiteName)
        val launchSiteLongName by bind<TextView>(R.id.itemLaunchSiteLongName)
    }
}