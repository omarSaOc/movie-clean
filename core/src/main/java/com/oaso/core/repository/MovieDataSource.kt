package com.oaso.core.repository

import com.oaso.core.data.Movie

interface MovieDataSource {
    suspend fun upcoming(apiKey : String) : List<Movie>
}