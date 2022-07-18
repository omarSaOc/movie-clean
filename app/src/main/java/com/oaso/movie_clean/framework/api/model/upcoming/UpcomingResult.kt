package com.oaso.movie_clean.framework.api.model.upcoming

import com.oaso.movie_clean.framework.api.model.popular.Result

data class UpcomingResult(
    val dates: Dates,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)