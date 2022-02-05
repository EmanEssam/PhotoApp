package com.test.photoapp.core.data.repo.photos

import com.test.photoapp.core.data.local.PhotoDao
import com.test.photoapp.core.data.models.photos.Photo
import com.test.photoapp.core.data.models.photos.PhotosResponse
import com.test.photoapp.core.data.remote.photos.PhotosRemoteDataSource
import javax.inject.Inject

class PhotosRepositoryImpl @Inject constructor(
    private val moviesRemoteDataSource: PhotosRemoteDataSource,
    private val localDataSource: PhotoDao
) : PhotosRepository {
    override suspend fun getMoviesPhotos(
        apiKey: String,
        page: Int,
        perPage: Int
    ): PhotosResponse<Any> {
        return moviesRemoteDataSource.getMoviesPhotos(apiKey, page, perPage)
    }

    override suspend fun insertPhotos(photos: List<Photo>) {
        localDataSource.insertAll(photos)
    }


}