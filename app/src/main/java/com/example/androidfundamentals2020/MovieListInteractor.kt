package com.example.androidfundamentals2020

import android.content.Context
import com.example.androidfundamentals2020.data.Movie
import com.example.androidfundamentals2020.data.loadMovies

class MovieListInteractor(private val context: Context) {

    suspend fun getMoviesList(): List<Movie> {
        return loadMovies(context)
    }
}