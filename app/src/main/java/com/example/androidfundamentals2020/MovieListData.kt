package com.example.androidfundamentals2020

import android.text.style.LineBackgroundSpan

class MovieListData (val background: String,
                    val name: String,
                    val tag: String,
                    val ratingStars: Int,
                    val rating: Int,
                    val time: Int
    ) {

    companion object {
        private var lastContactId = 0
        fun getMoviesListData(): ArrayList<MovieListData> {
            val movies = ArrayList<MovieListData>()
            movies.apply {
                add(MovieListData("@drawable/movie_list_fragment_back", "Avengers:End Game 4", "Action, Adventure, Fantasy", 4, 125, 137))
                add(MovieListData("@drawable/movie_list_fragment_back", "Avengers:End Game 2", "Action, Adventure, Fantasy", 2, 65, 147))
                add(MovieListData("@drawable/movie_list_fragment_back", "Avengers:End Game 3", "Action, Adventure, Fantasy", 3, 105, 127))
                add(MovieListData("@drawable/movie_list_fragment_back", "Avengers:End Game 1", "Action, Adventure, Fantasy", 1, 25, 37))
            }
            return movies
        }
    }
}