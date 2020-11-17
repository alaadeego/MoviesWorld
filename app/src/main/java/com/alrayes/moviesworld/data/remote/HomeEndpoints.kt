package com.alrayes.moviesworld.data.remote

import com.alrayes.moviesworld.data.models.response.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeEndpoints {

   // @GET("3/discover/movie?language=en&sort_by=popularity.desc&api_key=77c4f8629a06eda3d549804329edaf7f")

    @GET("3/discover/movie?language=en&sort_by=popularity.desc")
    suspend fun popularMovies(@Query("page")  page:Int): MoviesResponse

}