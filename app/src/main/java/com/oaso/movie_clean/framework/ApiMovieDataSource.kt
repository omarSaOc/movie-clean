package com.oaso.movie_clean.framework

import com.oaso.core.data.Movie
import com.oaso.core.repository.MovieDataSource
import com.oaso.movie_clean.framework.api.MovieService
import javax.inject.Inject

class ApiMovieDataSource @Inject constructor(private val movieService: MovieService) :
    MovieDataSource {

    override suspend fun upcoming(apiKey: String): List<Movie> =
        movieService.upcomingMovies(apiKey).results.map { it.toMovie() }

    override suspend fun nowPlaying(apiKey: String): List<Movie> =
        movieService.nowPlayingMovies(apiKey).results.map { it.toMovie() }

    override suspend fun popular(apiKey: String): List<Movie> =
        movieService.popularMovies(apiKey).results.map { it.toMovie() }
}