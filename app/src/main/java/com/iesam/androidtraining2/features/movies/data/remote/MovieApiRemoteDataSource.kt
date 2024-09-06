package com.iesam.androidtraining2.features.movies.data.remote

import com.iesam.androidtraining2.features.movies.domain.Movie

class MovieApiRemoteDataSource(private val movieApiService: MovieApiService) {

    suspend fun getMovies(): List<Movie> {
        val movies = movieApiService.getMovies()
        if (movies.isSuccessful) {
            return movies.body()!!
        } else {
            return emptyList()
        }
    }

}