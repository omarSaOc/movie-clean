package com.oaso.core.repository

class MovieRepository(private val dataSource: MovieDataSource) {
    suspend fun upcomingMovie(apiKey: String) = dataSource.upcoming(apiKey)
    suspend fun nowPlayingMovie(apiKey: String) = dataSource.nowPlaying(apiKey)
    suspend fun popularMovie(apiKey: String) = dataSource.popular(apiKey)
    suspend fun getVideos(url: String, apiKey: String) =
        dataSource.videos(url, apiKey)
}