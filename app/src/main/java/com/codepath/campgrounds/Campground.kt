package com.codepath.campgrounds

import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class CampgroundResponse(
    @SerialName("results")
    val data: List<Campground>?
)

@Keep
@Serializable
data class Campground(
    @SerialName("title")
    val name: String?,

    @SerialName("overview")
    val description: String?,

    @SerialName("release_date")
    val latLong: String?,

    @SerialName("poster_path")
    val posterPath: String? = null,

    @SerialName("backdrop_path")
    val backdropPath: String? = null,

    @SerialName("vote_average")
    val voteAverage: Double? = null,

    @SerialName("vote_count")
    val voteCount: Int? = null
) : java.io.Serializable {
    val imageUrl: String
        get() = if (!posterPath.isNullOrEmpty()) "https://image.tmdb.org/t/p/w500/$posterPath" else ""

    val backdropUrl: String
        get() = if (!backdropPath.isNullOrEmpty()) "https://image.tmdb.org/t/p/w780/$backdropPath" else imageUrl
}

@Keep
@Serializable
data class CampgroundImage(
    @SerialName("url") val url: String?,
    @SerialName("title") val title: String?
) : java.io.Serializable