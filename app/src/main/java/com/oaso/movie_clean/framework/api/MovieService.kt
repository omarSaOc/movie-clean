package com.oaso.movie_clean.framework.api

import com.oaso.movie_clean.BuildConfig
import com.oaso.movie_clean.framework.api.model.NowPlayingResult
import com.oaso.movie_clean.framework.api.model.UpcomingResult
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("movie/upcoming")
    suspend fun upcomingMovies(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ) : UpcomingResult

    @GET("movie/now_playing")
    suspend fun nowPlayingMovies(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ) : NowPlayingResult

}