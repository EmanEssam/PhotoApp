package com.test.photoapp.core.domain.movies

import com.test.photoapp.core.data.models.photos.PhotosResponse
import com.test.photoapp.core.data.repo.photos.PhotosRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetMoviesPhotosUseCaseImpl @Inject constructor(
    private val repository: PhotosRepository,
    private val ioDispatcher: CoroutineDispatcher
) : GetMoviesPhotosUseCase {

    override suspend fun getMoviesPhotos(
        apiKey: String,
        page: Int,
        pageCount: Int
    ): PhotosResponse<Any> {
        return repository.getMoviesPhotos(apiKey, page, pageCount)
    }
}