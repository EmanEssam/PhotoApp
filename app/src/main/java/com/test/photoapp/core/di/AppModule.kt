package com.test.photoapp.core.di

import android.content.Context
import com.test.photoapp.core.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase =
        AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun providePhotoDao(db: AppDatabase) = db.photoDao()
}