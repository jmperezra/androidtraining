package com.iesam.androidtraining2.features.movies.domain

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    operator suspend fun invoke(): List<Movie> {
        return movieRepository.getMovies()
    }

}