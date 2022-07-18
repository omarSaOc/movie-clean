package com.oaso.core.usecase

import com.oaso.core.repository.MovieRepository

class GetVideos(private val repository: MovieRepository) {
    suspend operator fun invoke(url: String, apiKey: String) =
        repository.getVideos(url, apiKey)
}