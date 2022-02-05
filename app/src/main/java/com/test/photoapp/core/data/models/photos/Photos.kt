package com.test.photoapp.core.data.models.photos



data class Photos(
    val page: Int,
    val pages: Int,
    val perpage: Int,
    val photo: List<Photo>,
    val total: Int
)