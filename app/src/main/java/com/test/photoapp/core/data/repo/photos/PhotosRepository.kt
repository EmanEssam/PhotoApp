package com.test.photoapp.core.data.repo.photos

import com.test.photoapp.core.data.models.photos.Photo
import com.test.photoapp.core.data.models.photos.PhotosResponse

interface PhotosRepository {

    suspend fun getMoviesPhotos(apiKey: String, page: Int, perPage: Int): PhotosResponse<Any>

    suspend fun insertPhotos(photos: List<Photo>)
}