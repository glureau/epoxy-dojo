package com.glureau.epoxy.dojo.controllers

import com.airbnb.epoxy.TypedEpoxyController
import com.glureau.epoxy.dojo.LaunchesFragment
import com.glureau.epoxy.dojo.data.dto.Launch
import com.glureau.epoxy.dojo.items.itemLaunchBanner
import com.glureau.epoxy.dojo.items.itemSeparator

class LaunchersController(val listener: LaunchesFragment.LaunchesFragmentListener?) :
    TypedEpoxyController<List<Launch>>() {
    override fun buildModels(data: List<Launch>?) {
        data?.forEach { launch ->
            itemLaunchBanner {
                // Epoxy use stable ids by default
                id(launch.hashCode())

                pictureUrl(launch.links?.mission_patch_small)
                title(launch.title())
                subTitle(launch.subtitle())
                onItemClicked { _ -> listener?.onLaunchClicked(launch) }
            }

            itemSeparator {
                id(1)
            }
        }
    }
}