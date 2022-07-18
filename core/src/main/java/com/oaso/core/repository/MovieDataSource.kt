package com.oaso.core.repository

import com.oaso.core.data.Movie
import com.oaso.core.data.Video

interface MovieDataSource {
    suspend fun upcoming(apiKey: String): List<Movie>
    suspend fun nowPlaying(apiKey: String): List<Movie>
    suspend fun popular(apiKey: String): List<Movie>
    suspend fun videos(url: String, apiKey: String) : List<Video>
}