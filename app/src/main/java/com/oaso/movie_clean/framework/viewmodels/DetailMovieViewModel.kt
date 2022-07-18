package com.oaso.movie_clean.framework.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oaso.core.data.Video
import com.oaso.movie_clean.BuildConfig
import com.oaso.movie_clean.framework.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailMovieViewModel @Inject constructor(
    private val useCase: UseCase
) : ViewModel() {

    private var _videos = MutableLiveData<List<Video>>()
    val videos: LiveData<List<Video>> get() = _videos

    private var _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    fun getVideos(id: Int) {
        viewModelScope.launch {
            val videoList = useCase.getVideos.invoke(
                BuildConfig.BASE_URL + "movie/${id}/videos",
                BuildConfig.API_KEY
            )
            _videos.postValue(videoList)
        }
    }
}