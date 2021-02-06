package com.example.androidfundamentals2020

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidfundamentals2020.data.Movie
import kotlinx.coroutines.launch

class MovieDetailsViewModel(private val interactor: MovieListInteractor) : ViewModel() {

    private var _mutableMovie: MutableLiveData<Movie> = MutableLiveData(
        Movie(
            id = 0,
            title = "",
            overview = "",
            poster = "",
            backdrop = "",
            ratings = 0f,
            numberOfRatings = 0,
            minimumAge = 0,
            runtime = 0,
            genres = listOf(),
            actors = listOf()
        )
    )
    val movie: LiveData<Movie> get() = _mutableMovie

    private var _selectedMovieList: MutableLiveData<Int> = MutableLiveData(0)
    val selectedMovieList: LiveData<Int> get() = _selectedMovieList

    fun getMovie() {
        viewModelScope.launch {
            val movieID = selectedMovieList.value
            val movies = interactor.getMoviesList()
            val movie = movies?.find { actor -> movieID == actor.id }
            if (movie != null) {
                _mutableMovie.postValue(movie)
            }
        }
    }

    fun setMovie(movieID: Int) {
        viewModelScope.launch {
            _selectedMovieList.postValue(movieID)
        }
    }
}