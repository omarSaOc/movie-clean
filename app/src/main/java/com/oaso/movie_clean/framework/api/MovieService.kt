package com.oaso.movie_clean.framework.api

import com.oaso.movie_clean.framework.api.model.now_playing.NowPlayingResult
import com.oaso.movie_clean.framework.api.model.popular.PopularResult
import com.oaso.movie_clean.framework.api.model.upcoming.UpcomingResult
import com.oaso.movie_clean.framework.api.model.video.VideoResult
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface MovieService {

    @GET("movie/upcoming")
    suspend fun upcomingMovies(
        @Query("api_key") apiKey: String
    ) : UpcomingResult

    @GET("movie/now_playing")
    suspend fun nowPlayingMovies(
        @Query("api_key") apiKey: String
    ) : NowPlayingResult

    @GET("movie/popular")
    suspend fun popularMovies(
        @Query("api_key") apiKey: String
    ) : PopularResult

    @GET
    suspend fun getVideos(
        @Url url: String,
        @Query("api_key") apiKey: String
    ) : VideoResult

}