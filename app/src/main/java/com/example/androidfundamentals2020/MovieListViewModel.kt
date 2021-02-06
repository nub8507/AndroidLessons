package com.example.androidfundamentals2020

import android.content.Context
import androidx.lifecycle.*
import androidx.work.WorkManager
import com.example.androidfundamentals2020.data.Movie
import kotlinx.coroutines.launch

class MovieListViewModel(
    private val interactor: MovieListInteractor,
    lifeCycleOwner: LifecycleOwner,
    applicationContext: Context
) : ViewModel() {

    val moviesList: LiveData<List<Movie>> =
        Transformations.map(interactor.moviesListModel) { return@map interactor.moviesListModel.value }

    init {
        WorkManager.getInstance(applicationContext)
            .getWorkInfoByIdLiveData(MovieAppClass.moviesRepository.constrainedRequest.id)
            .observe(lifeCycleOwner, interactor.moviesWorkObserver)
        loadMovies()
    }

    private fun loadMovies() {
        viewModelScope.launch {
            interactor.getMoviesList()
        }
    }

}
