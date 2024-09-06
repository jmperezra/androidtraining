package com.iesam.androidtraining2.features.movies.data.remote.db

import com.google.firebase.database.FirebaseDatabase
import com.iesam.androidtraining2.features.movies.data.remote.MovieRemoteDataSource
import com.iesam.androidtraining2.features.movies.domain.Movie
import kotlinx.coroutines.tasks.await

class MovieDbRemoteDataSource(private val movieDbRemote: FirebaseDatabase) :
    MovieRemoteDataSource {

    override suspend fun getMovies(): List<Movie> {
        return movieDbRemote
            .reference
            .root
            .get()
            .await()
            .children.map {
                it.getValue(MovieDbModel::class.java)!!.toDomain()
            }
    }
}