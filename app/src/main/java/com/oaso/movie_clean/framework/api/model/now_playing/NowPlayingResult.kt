package com.oaso.movie_clean.framework.api.model.now_playing

import com.oaso.movie_clean.framework.api.model.popular.Result

data class NowPlayingResult(
    val dates: Dates,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)