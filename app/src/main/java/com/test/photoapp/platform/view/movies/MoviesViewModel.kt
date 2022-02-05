package com.test.photoapp.platform.view.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.test.photoapp.core.domain.movies.GetMoviesPhotosUseCase
import com.test.photoapp.platform.view.movies.paging.MoviesPagingResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val getMoviesPhotosUseCase: GetMoviesPhotosUseCase) :
    ViewModel() {
    @FlowPreview
    fun getMovies() =
        Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                MoviesPagingResource(
                    moviesPhotosUseCase = getMoviesPhotosUseCase,
                    pageCount = 10
                )
            }
        ).flow.cachedIn(viewModelScope)

}