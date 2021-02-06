package com.example.androidfundamentals2020

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MovieListViewModelFactory(
    private val interactor: MovieListInteractor,
    private val lifeCycleOwner: LifecycleOwner,
    private val applicationContext: Context
) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        MovieListViewModel::class.java -> MovieListViewModel(
            interactor,
            lifeCycleOwner,
            applicationContext
        )
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}
