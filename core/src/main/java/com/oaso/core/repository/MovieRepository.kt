package com.oaso.core.repository

class MovieRepository(private val dataSource: MovieDataSource) {
    suspend fun upcomingMovie(apiKey : String) = dataSource.upcoming(apiKey)
}