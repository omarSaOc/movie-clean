package com.oaso.movie_clean.framework

import com.oaso.core.usecase.GetVideos
import com.oaso.core.usecase.NowPlayingMovie
import com.oaso.core.usecase.PopularMovie
import com.oaso.core.usecase.UpcomingMovie

data class UseCase(
    val upcomingMovie: UpcomingMovie,
    val nowPlayingMovie: NowPlayingMovie,
    val popularMovie: PopularMovie,
    val getVideos : GetVideos
)