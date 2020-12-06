package com.example.androidfundamentals2020

class MovieListData (
                    val background: Int,
                    val name: String,
                    val tag: String,
                    val ratingStars: Int,
                    val reviews: Int,
                    val time: Int,
                    val pgRating: String
    ) {

    companion object {
        fun getMoviesListData(): List<MovieListData> {
            val movies = listOf(
                MovieListData(R.drawable.movie_list_fragment_back1, "Avengers:End Game", "Action, Adventure, Fantasy", 4, 125, 137, "13+"),
                MovieListData(R.drawable.movie_list_fragment_back2, "Tenet", "Action, Sci-Fi, Thriller ", 5, 98, 97, "16+"),
                MovieListData(R.drawable.movie_list_fragment_back3, "Black Widow", "Action, Adventure, Sci-Fi", 4, 38, 102, "13+"),
                MovieListData(R.drawable.movie_list_fragment_back4, "Wonder Woman 1984", "Action, Adventure, Fantasy", 5, 74, 120, "13+")
            )
            return movies
        }
    }
}