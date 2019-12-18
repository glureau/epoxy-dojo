package com.glureau.epoxy.dojo.controllers

import android.graphics.Color
import com.airbnb.epoxy.TypedEpoxyController
import com.glureau.epoxy.data.dto.Launch
import com.glureau.epoxy.dojo.ui.items.*

class LaunchDetailsController : TypedEpoxyController<Launch>() {
    override fun buildModels(launch: Launch) {
        itemLaunchBanner {
            // Epoxy use stable ids by default
            id(launch.hashCode())

            pictureUrl(launch.links?.mission_patch_small)
            title(launch.title())
            subTitle(launch.subtitle())
        }

        itemLogo {
            id(0)
        }

        itemSeparator {
            id(1)
            color(Color.RED)
        }

        launch.rocket?.let { rocket ->
            itemLaunchRocket {
                id(rocket.hashCode())
                rocketId("Rocket Id:" + rocket.rocket_id)
                rocketName("Rocket Name:" + rocket.rocket_name)
                rocketType("Rocket Type:" + rocket.rocket_type)
            }
            itemSeparator {
                id(2)
                color(Color.MAGENTA)
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

        itemFooter {
            id(3)
        }
    }
}