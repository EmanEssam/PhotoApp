package com.test.photoapp.core.di

import com.test.photoapp.core.data.repo.photos.PhotosRepository
import com.test.photoapp.core.data.repo.photos.PhotosRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
    @ViewModelScoped
    fun bindMoviesRepository(moviesRepository: PhotosRepositoryImpl): PhotosRepository =
        moviesRepository
}