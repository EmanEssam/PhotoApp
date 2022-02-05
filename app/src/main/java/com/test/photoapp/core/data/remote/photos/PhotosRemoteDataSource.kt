package com.test.photoapp.core.data.remote.photos

import com.test.photoapp.core.data.models.photos.PhotosResponse

interface PhotosRemoteDataSource {
    suspend fun getMoviesPhotos(apiKey: String, page: Int, perPage: Int): PhotosResponse<Any>
}