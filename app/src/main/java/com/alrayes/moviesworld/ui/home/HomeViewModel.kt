package com.alrayes.moviesworld.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alrayes.moviesworld.BuildConfig
import com.alrayes.moviesworld.data.models.response.MoviesResponse
import com.alrayes.moviesworld.domain.repositories.HomeRepository
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    private val _moviesList = MutableLiveData<List<MoviesResponse.Movie>>()
    val moviesList: LiveData<List<MoviesResponse.Movie>> = _moviesList

    private var PAGE_NUM = 1
    fun fetchMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                Timber.tag("runCatching").d("..runCatching")

                homeRepository.fetchMovies(PAGE_NUM)
            }.onSuccess { data ->
                Timber.tag("onSuccess").d("..onSuccess")

                // val temp = _moviesList.value?.toMutableList() ?: mutableListOf()
                //temp.addAll(data.movies?: emptyList())
                _moviesList.postValue(data.movies ?: emptyList())
                PAGE_NUM++
            }.onFailure { throwable ->

                when (throwable) {
                    is IOException -> {
                        Timber.tag("onFailure").d("Check Internet")
                    }
                    is HttpException -> {
                        Timber.tag("onFailure").d(throwable.message())

                        when (throwable.code()) {
                            400 -> {

                                Timber.tag("onFailure..").d(throwable.response()?.message())

                            }
                        }
                    }

                }
            }
        }
    }
}