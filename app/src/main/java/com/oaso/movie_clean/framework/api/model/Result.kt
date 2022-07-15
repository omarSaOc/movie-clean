package com.oaso.movie_clean.framework.api.model

import com.oaso.core.data.Movie

data class Result(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
) {
    companion object {
        fun fromMovie(movie: Movie) =
            Result(
                movie.adult,
                movie.backdrop_path,
                movie.genre_ids,
                movie.id,
                movie.original_language,
                movie.original_title,
                movie.overview,
                movie.popularity,
                movie.poster_path,
                movie.release_date,
                movie.title,
                movie.video,
                movie.vote_average,
                movie.vote_count
            )
    }

    fun toMovie() = Movie(
        adult,
        backdrop_path,
        genre_ids,
        id,
        original_language,
        original_title,
        overview,
        popularity,
        poster_path,
        release_date,
        title,
        video,
        vote_average,
        vote_count
    )
}