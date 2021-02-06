package com.example.androidfundamentals2020

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.work.WorkInfo
import com.example.androidfundamentals2020.MovieAppClass.Companion.moviesRepository
import com.example.androidfundamentals2020.data.Movie
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

    val moviesWorkObserver = Observer<WorkInfo> { workInfo ->
        if (workInfo.state == WorkInfo.State.SUCCEEDED) {
            scopeData.launch {
                _mutableMovieListModel.postValue(moviesRepository.readMoviesFromDb())
            }
        }
    }

    fun getMovieById(movieID: Long) {
        scopeData.launch {
            _mutableMovieModel.postValue(
                moviesRepository.moviesDao.getById(movieID)
            )
        }
    }

    fun getMoviesList() {
        scopeData.launch {
            _mutableMovieListModel.postValue(moviesRepository.readMoviesFromDb())
        }
        scopeInternet.launch {
            _mutableMovieListModel.postValue(moviesRepository.fillMovies())
        }
    }

}
