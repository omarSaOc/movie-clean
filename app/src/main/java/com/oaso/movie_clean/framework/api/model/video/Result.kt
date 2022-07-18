package com.oaso.movie_clean.framework.api.model.video

import com.oaso.core.data.Video

data class Result(
    val id: String,
    val iso_3166_1: String,
    val iso_639_1: String,
    val key: String,
    val name: String,
    val official: Boolean,
    val published_at: String,
    val site: String,
    val size: Int,
    val type: String
) {
    fun toVideo() = Video(
        id,
        iso_3166_1,
        iso_639_1,
        key,
        name,
        official,
        published_at,
        site,
        size,
        type
    )
}