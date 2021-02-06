package com.example.androidfundamentals2020

import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import com.example.androidfundamentals2020.data.Movie
import com.example.androidfundamentals2020.data.loadMovies
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

class MoviesRepository {

    private val constraints = Constraints.Builder().setRequiredNetworkType(NetworkType.UNMETERED)
        .setRequiresCharging(true).build()
    val constrainedRequest =
        PeriodicWorkRequest.Builder(
            MoviesUpdateWorker::class.java,
            8,
            TimeUnit.HOURS,
            7,
            TimeUnit.HOURS
        )
            .setConstraints(constraints)
            .build()

    val moviesDao = MovieAppClass.db.moviesDao()

    private val scopeData = CoroutineScope(Dispatchers.IO)

    fun fillMovies(): List<Movie> {
        scopeData.launch {
            var movies = loadMovies()
            movies?.forEach {
                MovieAppClass.db.moviesDao().insert(it.movieData)
                it.actors.forEach { MovieAppClass.db.actorsDao().insert(it) }
                it.genres.forEach { MovieAppClass.db.genresDao().insert(it) }
            }
        }
        return readMoviesFromDb()
    }

    fun readMoviesFromDb(): List<Movie> {
        var list: List<Movie> = listOf()
        runBlocking { list = moviesDao.getAll() }
        return list
    }


}
