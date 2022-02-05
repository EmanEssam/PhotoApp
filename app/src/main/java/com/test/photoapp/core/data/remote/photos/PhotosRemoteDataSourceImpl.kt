package com.test.photoapp.core.data.remote.photos

import com.test.photoapp.core.data.models.photos.PhotosResponse
import javax.inject.Inject

class PhotosRemoteDataSourceImpl @Inject constructor(private val moviesPhotosApiInterface: PhotosApiInterface) :
    PhotosRemoteDataSource {
    override suspend fun getMoviesPhotos(
        apiKey: String,
        page: Int,
        perPage: Int
    ): PhotosResponse<Any> {
        return moviesPhotosApiInterface.getPhotos(apiKey, page = page, per_page = perPage)
    }
}