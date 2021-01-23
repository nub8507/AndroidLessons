package com.example.androidfundamentals2020

import androidx.lifecycle.*
import com.example.androidfundamentals2020.db.DbMovieEntity
import kotlinx.coroutines.launch

class MovieDetailsViewModel(private val interactor: MovieListInteractor) : ViewModel() {

    private var _selectedMovieList: MutableLiveData<Long> = MutableLiveData(0)
    val selectedMovieList: LiveData<Long> get() = _selectedMovieList

    val movie: LiveData<DbMovieEntity> =
        Transformations.map(interactor.movieModel) { return@map interactor.movieModel.value }

    fun setMovie(movieID: Long) {
        viewModelScope.launch {
            _selectedMovieList.postValue(movieID)
            interactor.getMovieById(movieID)
        }
    }
}