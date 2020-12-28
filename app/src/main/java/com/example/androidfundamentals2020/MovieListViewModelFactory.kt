package com.example.androidfundamentals2020

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MovieListViewModelFactory(private val interactor: MovieListInteractor) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        MovieListViewModel::class.java -> MovieListViewModel(interactor)
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}