package com.alrayes.moviesworld.data.repository

import com.alrayes.moviesworld.data.models.response.MoviesResponse
import com.alrayes.moviesworld.data.remote.HomeEndpoints
import com.alrayes.moviesworld.domain.repositories.HomeRepository
import timber.log.Timber

class HomeRepositoryImpl(private val homeEndpoints: HomeEndpoints) :
    HomeRepository {

    override suspend fun fetchMovies(page: Int): MoviesResponse {
        return homeEndpoints.popularMovies(page)
    }


}