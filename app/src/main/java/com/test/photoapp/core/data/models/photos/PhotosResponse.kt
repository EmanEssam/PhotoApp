package com.test.photoapp.core.data.models.photos

data class PhotosResponse<T>(
    val photos: Photos,
    val stat: String
)