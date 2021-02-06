package com.example.androidfundamentals2020

import androidx.lifecycle.*
import com.example.androidfundamentals2020.data.Movie
import kotlinx.coroutines.launch

class MovieDetailsViewModel(private val interactor: MovieListInteractor) : ViewModel() {

    private var _selectedMovieList: MutableLiveData<Long> = MutableLiveData(0)

    val movie: LiveData<Movie> =
        Transformations.map(interactor.movieModel) { return@map interactor.movieModel.value }

    fun setMovie(movieID: Long) {
        viewModelScope.launch {
            interactor.getMovieById(movieID)
        }
    }
}