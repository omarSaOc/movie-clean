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
class UpcomingViewModel @Inject constructor(
    private val useCase: UseCase
) : ViewModel() {

    private var _movies = MutableLiveData<List<Movie>>()
    private val movie :LiveData<List<Movie>> get() = _movies

    fun getUpcoming() {
        viewModelScope.launch {
            val movieList = useCase.upcomingMovie.invoke(BuildConfig.API_KEY)
            _movies.postValue(movieList)
        }
    }

}