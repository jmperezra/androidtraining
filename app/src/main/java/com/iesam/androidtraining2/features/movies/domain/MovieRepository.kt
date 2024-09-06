package com.iesam.androidtraining2.features.movies.domain

interface MovieRepository {
    suspend fun getMovies(): List<Movie>
}