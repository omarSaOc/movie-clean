package com.oaso.core.usecase

import com.oaso.core.repository.MovieRepository

class UpcomingMovie(private val repository: MovieRepository) {
    suspend operator fun invoke(apiKey: String) = repository.upcomingMovie(apiKey)
}