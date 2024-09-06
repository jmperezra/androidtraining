package com.iesam.androidtraining2.features.movies.data.local

import com.iesam.androidtraining2.features.movies.domain.Movie

fun Movie.toEntity() = MovieEntity(
    this.id, this.title, this.poster, this.year, this.rating
)

fun MovieEntity.toDomain() = Movie(
    this.id, this.poster, this.title, this.year, this.rating
)