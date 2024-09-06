package com.iesam.androidtraining2.features.movies.data

import com.iesam.androidtraining2.features.movies.data.local.MovieDbLocalDataSource
import com.iesam.androidtraining2.features.movies.data.remote.MovieApiRemoteDataSource
import com.iesam.androidtraining2.features.movies.domain.Movie
import com.iesam.androidtraining2.features.movies.domain.MovieRepository

class MovieDataRepository(
    private val localDataSource: MovieDbLocalDataSource,
    private val remoteDataSource: MovieApiRemoteDataSource
) : MovieRepository {

    override suspend fun getMovies(): List<Movie> {
        val cacheMovies = localDataSource.getMovies()
        if (cacheMovies.isEmpty()) {
            val remoteMovies = remoteDataSource.getMovies()
            localDataSource.saveMovies(remoteMovies)
            return remoteMovies
        } else {
            return cacheMovies
        }
    }
}