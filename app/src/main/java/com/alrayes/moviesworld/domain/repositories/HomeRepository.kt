package com.alrayes.moviesworld.domain.repositories

import com.alrayes.moviesworld.data.models.response.MoviesResponse

interface HomeRepository {
    suspend  fun fetchMovies(page: Int): MoviesResponse

}