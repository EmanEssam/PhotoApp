package com.test.photoapp.core.di

import com.test.photoapp.core.domain.movies.GetMoviesPhotosUseCase
import com.test.photoapp.core.domain.movies.GetMoviesPhotosUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {
    @Provides
    fun provideMoviesUseCase(
        moviesPhotosUseCaseImpl: GetMoviesPhotosUseCaseImpl
    ): GetMoviesPhotosUseCase {
        return moviesPhotosUseCaseImpl
    }

}