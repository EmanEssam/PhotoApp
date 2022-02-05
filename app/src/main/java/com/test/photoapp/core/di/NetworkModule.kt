package com.test.photoapp.core.di

import android.content.Context
import com.test.photoapp.core.data.remote.photos.PhotosApiInterface
import com.test.photoapp.core.data.remote.photos.PhotosRemoteDataSource
import com.test.photoapp.core.data.remote.photos.PhotosRemoteDataSourceImpl
import com.test.photoapp.core.helper.helper.RetrofitFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideMoviesPhotosApi(
        remoteDataSource: RetrofitFactory,
        @ApplicationContext context: Context
    ): PhotosApiInterface {
        return remoteDataSource.getService()
    }

    @Provides
    fun provideMoviesRemoteDataSourceImpl(
        moviesRemoteDataSourceImpl: PhotosRemoteDataSourceImpl
    ): PhotosRemoteDataSource {
        return moviesRemoteDataSourceImpl
    }
}