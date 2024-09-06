package com.iesam.androidtraining2.app.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.iesam.androidtraining2.features.movies.data.local.MovieDao
import com.iesam.androidtraining2.features.movies.data.local.MovieEntity

@Database(
    entities = [MovieEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}
