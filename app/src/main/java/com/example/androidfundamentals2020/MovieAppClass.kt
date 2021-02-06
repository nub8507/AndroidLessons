package com.example.androidfundamentals2020

import android.app.Application
import androidx.room.Room
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.WorkManager
import com.example.androidfundamentals2020.db.MovieListDatabase
import com.example.androidfundamentals2020.db.MovieListDbContract

class MovieAppClass : Application() {

    companion object {
        lateinit var db: MovieListDatabase
        lateinit var moviesRepository: MoviesRepository
    }

    override fun onCreate() {
        super.onCreate()

        moviesRepository = MoviesRepository()

        db = Room.databaseBuilder(
            applicationContext,
            MovieListDatabase::class.java,
            MovieListDbContract.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()

        WorkManager.getInstance(applicationContext)
            .enqueueUniquePeriodicWork(
                "MOVIES_WORK_TAG",
                ExistingPeriodicWorkPolicy.REPLACE,
                moviesRepository.constrainedRequest
            )
    }

}
