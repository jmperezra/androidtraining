package com.iesam.androidtraining2.features.movies

import android.content.Context
import androidx.room.Room
import com.iesam.androidtraining2.app.db.AppDatabase
import com.iesam.androidtraining2.features.movies.data.MovieDataRepository
import com.iesam.androidtraining2.features.movies.data.local.MovieDao
import com.iesam.androidtraining2.features.movies.data.local.MovieDbLocalDataSource
import com.iesam.androidtraining2.features.movies.data.remote.MovieApiRemoteDataSource
import com.iesam.androidtraining2.features.movies.data.remote.MovieApiService
import com.iesam.androidtraining2.features.movies.domain.GetMoviesUseCase
import com.iesam.androidtraining2.features.movies.domain.MovieRepository
import com.iesam.androidtraining2.features.movies.presentation.MoviesViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieFactory(private val context: Context) {

    fun provideViewModel(): MoviesViewModel {
        return MoviesViewModel(provideGetMoviesUseCase())
    }

    private fun provideGetMoviesUseCase(): GetMoviesUseCase {
        return GetMoviesUseCase(provideMovieRepository())
    }

    private fun provideMovieRepository(): MovieRepository {
        return MovieDataRepository(
            provideMovieDbLocalDataSource(),
            provideMovieApiRemoteDataSource()
        )
    }

    private fun provideMovieApiRemoteDataSource(): MovieApiRemoteDataSource {
        return MovieApiRemoteDataSource(provideMovieApiService())
    }

    private fun provideMovieDbLocalDataSource(): MovieDbLocalDataSource {
        return MovieDbLocalDataSource(provideMovieDao())
    }

    private fun provideMovieDao(): MovieDao {
        return provideDatabase().movieDao()
    }

    private fun provideDatabase(): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "database-movies"
        ).build()
    }

    private fun provideApiClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://freetestapi.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun provideMovieApiService(): MovieApiService {
        return provideApiClient().create(MovieApiService::class.java)
    }
}