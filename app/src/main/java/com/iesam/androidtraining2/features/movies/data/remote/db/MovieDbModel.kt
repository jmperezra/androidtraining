package com.iesam.androidtraining2.features.movies.data.remote.db

import com.iesam.androidtraining2.features.movies.domain.Movie

class MovieDbModel() {
    var id: Int = 0
    var poster: String = ""
    var title: String = ""
    var year: Int = 0
    var rating: Double = 0.0
}

fun MovieDbModel.toDomain(): Movie {
    return Movie(
        id = this.id.toString(),
        poster = this.poster,
        title = this.title,
        year = this.year.toString(),
        rating = this.rating.toString()
    )
}