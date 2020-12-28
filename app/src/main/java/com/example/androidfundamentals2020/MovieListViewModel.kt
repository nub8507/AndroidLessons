package com.example.androidfundamentals2020

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidfundamentals2020.data.Movie
import kotlinx.coroutines.launch


class MovieListViewModel(private val interactor: MovieListInteractor) : ViewModel() {

    private var _mutableMovieList: MutableLiveData<List<Movie>> = MutableLiveData(emptyList())
    val moviesList: LiveData<List<Movie>> get() = _mutableMovieList

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            val movies = interactor.getMoviesList()
            _mutableMovieList.postValue(interactor.getMoviesList())
        }
    }

}