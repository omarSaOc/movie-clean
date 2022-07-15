package com.oaso.movie_clean.framework.di

import com.oaso.core.repository.MovieRepository
import com.oaso.movie_clean.framework.ApiMovieDataSource
import com.oaso.movie_clean.framework.api.MovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        service: MovieService
    ) = MovieRepository(ApiMovieDataSource(service))
}