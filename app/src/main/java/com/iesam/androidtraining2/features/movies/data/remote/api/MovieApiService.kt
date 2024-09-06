package com.iesam.androidtraining2.features.movies.data.remote.api

import com.iesam.androidtraining2.features.movies.domain.Movie
import retrofit2.Response
import retrofit2.http.GET

interface MovieApiService {
    @GET("https://freetestapi.com/api/v1/movies")
    suspend fun getMovies(): Response<List<Movie>>
}