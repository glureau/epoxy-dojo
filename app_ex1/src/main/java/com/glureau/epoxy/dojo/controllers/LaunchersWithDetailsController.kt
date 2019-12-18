package com.glureau.epoxy.dojo.controllers

import com.airbnb.epoxy.TypedEpoxyController
import com.glureau.epoxy.dojo.LaunchesFragment
import com.glureau.epoxy.dojo.LaunchesWithDetailsFragment
import com.glureau.epoxy.dojo.data.dto.Launch
import com.glureau.epoxy.dojo.items.*

class LaunchersWithDetailsController(val listener: LaunchesWithDetailsFragment.LaunchesWithDetailsFragmentListener?) :
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

            launch.rocket?.let { rocket ->
                itemLaunchRocket {
                    id(rocket.hashCode())
                    rocketId("Rocket Id:" + rocket.rocket_id)
                    rocketName("Rocket Name:" + rocket.rocket_name)
                    rocketType("Rocket Type:" + rocket.rocket_type)
                }
            }

            launch.launch_site?.let { site ->
                itemLaunchSite {
                    id(site.hashCode())
                    launchSiteId("Site code:" + site.site_id)
                    launchSiteName("Name:" + site.site_name)
                    launchSiteLongName("Full name:" + site.site_name_long)
                }
            }

            itemSeparator {
                id(1)
            }
        }
    }
}