package com.example.androidfundamentals2020

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidfundamentals2020.data.Movie
import com.example.androidfundamentals2020.data.loadMovies
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieListInteractor() {

    private val scopeData = CoroutineScope(Dispatchers.IO)
    private val scopeInternet = CoroutineScope(Dispatchers.IO)

    private var _mutableMovieListModel: MutableLiveData<List<Movie>> =
        MutableLiveData(emptyList())
    val moviesListModel: LiveData<List<Movie>> get() = _mutableMovieListModel

    private var _mutableMovieModel: MutableLiveData<Movie> = MutableLiveData(Movie())
    val movieModel: LiveData<Movie> get() = _mutableMovieModel

    suspend fun getMovieById(movieID: Long) {
        scopeData.launch {
            _mutableMovieModel.postValue(
                MovieAppClass.db.moviesDao().getById(movieID)
            )
        }
    }

    suspend fun getMoviesList() {
        readMoviesFromDb()
        scopeInternet.launch { fillMovies() }
    }

    private suspend fun fillMovies() {
        var movies = loadMovies()
        movies?.forEach {
            MovieAppClass.db.moviesDao().insert(it.movieData)
            it.actors.forEach { MovieAppClass.db.actorsDao().insert(it) }
            it.genres.forEach { MovieAppClass.db.genresDao().insert(it) }
        }
        readMoviesFromDb()
    }

    private suspend fun readMoviesFromDb() {
        scopeData.launch { _mutableMovieListModel.postValue(MovieAppClass.db.moviesDao().getAll()) }
    }
}