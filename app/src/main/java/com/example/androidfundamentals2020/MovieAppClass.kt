package com.example.androidfundamentals2020

import android.app.Application
import androidx.room.Room
import com.example.androidfundamentals2020.db.MovieListDatabase
import com.example.androidfundamentals2020.db.MovieListDbContract

class MovieAppClass : Application() {

    companion object {
        lateinit var db: MovieListDatabase
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            MovieListDatabase::class.java,
            MovieListDbContract.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}