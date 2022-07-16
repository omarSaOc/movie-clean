package com.oaso.core.usecase

import com.oaso.core.repository.MovieRepository

class NowPlayingMovie(private val repository: MovieRepository) {
    suspend operator fun invoke(apiKey : String) = repository.nowPlayingMovie(apiKey)
}