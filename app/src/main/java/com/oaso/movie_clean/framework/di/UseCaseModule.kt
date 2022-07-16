package com.oaso.movie_clean.framework.di

import com.oaso.core.repository.MovieRepository
import com.oaso.core.usecase.NowPlayingMovie
import com.oaso.core.usecase.UpcomingMovie
import com.oaso.movie_clean.framework.UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule() {

    @Provides
    fun getUseCase(repository: MovieRepository) = UseCase(
        UpcomingMovie(repository),
        NowPlayingMovie(repository)
    )
}