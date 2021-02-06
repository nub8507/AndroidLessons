package com.example.androidfundamentals2020

import androidx.lifecycle.*
import com.example.androidfundamentals2020.data.Movie
import kotlinx.coroutines.launch

class MovieListViewModel(private val interactor: MovieListInteractor) : ViewModel() {

    val moviesList: LiveData<List<Movie>> =
        Transformations.map(interactor.moviesListModel) { return@map interactor.moviesListModel.value }

    init {
        loadMovies()
    }

    private fun loadMovies() {
        viewModelScope.launch {
            interactor.getMoviesList()
        }
    }

}
