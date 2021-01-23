package com.example.androidfundamentals2020.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [MovieDbEntity::class, ActorDbEntity::class, GenreDbEntity::class],
    version = 1
)
abstract class MovieListDatabase : RoomDatabase() {
    abstract fun moviesDao(): MoviesListDbDao
    abstract fun actorsDao(): ActorDbDao
    abstract fun genresDao(): GenreDbDao

    companion object {

        fun create(applicationContext: Context): MovieListDatabase = Room.databaseBuilder(
            applicationContext,
            MovieListDatabase::class.java,
            MovieListDbContract.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}