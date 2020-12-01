package com.example.androidfundamentals2020

class MovieActorData(val image: String,
                     val name: String
                    )  {

    companion object {
        private var lastContactId = 0
        fun getMoviesListData(): ArrayList<MovieActorData> {
            val movies = ArrayList<MovieActorData>()
            movies.apply {
                add(MovieActorData("@drawable/movie1", "Robert Downey Jr."))
                add(MovieActorData("@drawable/movie2", "Chris Evans"))
                add(MovieActorData("@drawable/movie3", "Mark Ruffalo"))
                add(MovieActorData("@drawable/movie4", "Chris Hemsworth"))
            }
            return movies
        }
    }

}