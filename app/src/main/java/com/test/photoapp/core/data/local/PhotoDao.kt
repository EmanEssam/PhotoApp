package com.test.photoapp.core.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.test.photoapp.core.data.models.photos.Photo

@Dao
interface PhotoDao {

    @Query("SELECT * FROM photos")
    fun getAllPhotos(): PagingSource<Int, Photo>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(photos: List<Photo>)



}