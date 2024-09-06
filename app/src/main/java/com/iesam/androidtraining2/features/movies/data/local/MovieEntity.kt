package com.iesam.androidtraining2.features.movies.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "poster") val poster: String,
    @ColumnInfo(name = "year") val year: String,
    @ColumnInfo(name = "rating") val rating: String,
)