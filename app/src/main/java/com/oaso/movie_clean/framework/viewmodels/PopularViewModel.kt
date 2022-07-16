package com.oaso.movie_clean.framework.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oaso.core.data.Movie
import com.oaso.movie_clean.BuildConfig
import com.oaso.movie_clean.framework.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularViewModel @Inject constructor(
    private val useCase: UseCase
) : ViewModel() {

    private var _movies = MutableLiveData<List<Movie>>()
    val movie: LiveData<List<Movie>> get() = _movies

    private var _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    fun getPopularMovies() {
        viewModelScope.launch {
            _loading.postValue(true)
            val movieList = useCase.popularMovie.invoke(BuildConfig.API_KEY)
            _loading.postValue(false)
            _movies.postValue(movieList)
        }
    }
}