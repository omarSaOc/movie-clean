package com.oaso.movie_clean.framework.api.model.popular

data class PopularResult(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)