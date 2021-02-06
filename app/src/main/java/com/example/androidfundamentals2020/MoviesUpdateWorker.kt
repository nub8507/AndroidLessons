package com.example.androidfundamentals2020

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class MoviesUpdateWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        MovieAppClass.moviesRepository.fillMovies()
        return Result.success()
    }

}
