package com.iesam.androidtraining2.features.movies.data.local

import com.iesam.androidtraining2.features.movies.domain.Movie

class MovieDbLocalDataSource(private val movieDao: MovieDao) {

    suspend fun saveMovies(movies: List<Movie>) {
        movies.forEach { movie ->
            movieDao.insert(movie.toEntity())
        }
    }

    suspend fun getMovies(): List<Movie> {
        return movieDao.getAll().map { it.toDomain() }
    }
}