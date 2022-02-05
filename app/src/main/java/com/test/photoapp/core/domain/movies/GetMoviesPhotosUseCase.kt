package com.test.photoapp.core.domain.movies

import com.test.photoapp.core.data.models.photos.PhotosResponse

interface GetMoviesPhotosUseCase {
    suspend fun getMoviesPhotos(
        apiKey:String,
        page: Int,
        pageCount: Int
    ): PhotosResponse<Any>
}