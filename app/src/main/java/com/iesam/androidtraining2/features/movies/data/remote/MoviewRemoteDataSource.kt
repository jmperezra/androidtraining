package com.iesam.androidtraining2.features.movies.data.remote

import com.iesam.androidtraining2.features.movies.domain.Movie

interface MoviewRemoteDataSource {
    suspend fun getMovies(): List<Movie>
}