package com.oaso.movie_clean.framework.api.model

data class NowPlayingResult(
    val dates: Dates,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)