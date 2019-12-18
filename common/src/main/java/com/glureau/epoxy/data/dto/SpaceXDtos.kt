package com.glureau.epoxy.data.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Launch(
    val flight_number: Int? = null,
    val mission_name: String? = null,
    val mission_id: List<String> = emptyList(),
    val upcoming: Boolean? = null,
    val launch_year: Int? = null,
    val rocket: Rocket? = null,
    val launch_site: LaunchSite? = null,
    val launch_success: Boolean? = null,
    val launch_failure_details: LaunchFailureDetails? = null,
    val links: Links? = null
): Parcelable {
    // Should be defined in ViewModel. Written here for dojo simplicity
    fun title() = "#$flight_number $mission_name ($launch_year)"

    fun subtitle() = when {
        upcoming == true -> "Not started yet.\nLaunch year: $launch_year"
        launch_success == true -> "Flight success!"
        else -> "Failure: ${launch_failure_details?.reason}"
    }
}

@Parcelize
data class Rocket(
    val rocket_id: String? = null,
    val rocket_name: String? = null,
    val rocket_type: String? = null,
    val details: String? = null
): Parcelable

@Parcelize
data class LaunchSite(
    val site_id: String? = null,
    val site_name: String? = null,
    val site_name_long: String? = null
): Parcelable

@Parcelize
data class LaunchFailureDetails(
    val time: Long? = null,
    val altitude: Double? = null,
    val reason: String? = null
): Parcelable

@Parcelize
data class Links(
    val mission_patch: String? = null,
    val mission_patch_small: String? = null,
    val article_link: String? = null,
    val wikipedia: String? = null,
    val video_link: String? = null,
    val youtube_id: String? = null
): Parcelable