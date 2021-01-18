package com.example.androidfundamentals2020

import com.example.androidfundamentals2020.data.Movie
import com.example.androidfundamentals2020.data.loadMovies

class MovieListInteractor() {

    suspend fun getMoviesList(): List<Movie>? {
        return loadMovies()
    }
}