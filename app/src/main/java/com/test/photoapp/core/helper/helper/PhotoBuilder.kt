package com.test.photoapp.core.helper.helper

const val PHOTO_BASE_URL = "https://farm"
const val SLASH = "/"
const val UNDERSCORE = "_"
const val JPG = ".jpg"

object PhotoBuilder {

    fun getPhotoUrl(farm: Int, server: String, id: String, secret: String): String {

        return "$PHOTO_BASE_URL$farm.staticflickr.com/$server$SLASH$id$UNDERSCORE$secret$JPG".trim()
    }


}