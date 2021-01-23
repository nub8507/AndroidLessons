package com.example.androidfundamentals2020

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidfundamentals2020.data.loadMovies
import com.example.androidfundamentals2020.db.DbMovieEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MovieListInteractor() {

    private val scopeData = CoroutineScope(Dispatchers.IO)
    private val scopeInternet = CoroutineScope(Dispatchers.IO)

    private var _mutableMovieListModel: MutableLiveData<List<DbMovieEntity>> =
        MutableLiveData(emptyList())
    val moviesListModel: LiveData<List<DbMovieEntity>> get() = _mutableMovieListModel

    private var _mutableMovieModel: MutableLiveData<DbMovieEntity> = MutableLiveData(DbMovieEntity())
    val movieModel: LiveData<DbMovieEntity> get() = _mutableMovieModel

    suspend fun getMovieById(movieID: Long) {
        scopeData.launch {_mutableMovieModel.postValue(MovieAppClass.db.moviesDao().getById(movieID))}
    }

    suspend fun getMoviesList() {
        scopeData.launch {_mutableMovieListModel.postValue(MovieAppClass.db.moviesDao().getAll())}
        scopeInternet.launch { fillMovies() }
    }

    private suspend fun fillMovies(){
        var movies = loadMovies()
        movies?.forEach { MovieAppClass.db.moviesDao().insert(it) }
        _mutableMovieListModel.postValue(movies)
    }
}