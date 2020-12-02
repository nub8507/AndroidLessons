package com.example.androidfundamentals2020

class MovieActorData(val image: Int,
                     val name: String
                    )  {

    companion object {
        fun getActorsListData(): ArrayList<MovieActorData> {
            val actors = ArrayList<MovieActorData>()
            actors.apply {
                add(MovieActorData(R.drawable.movie1, "Robert Downey Jr."))
                add(MovieActorData(R.drawable.movie2,"Chris Evans"))
                add(MovieActorData(R.drawable.movie3, "Mark Ruffalo"))
                add(MovieActorData(R.drawable.movie4, "Chris Hemsworth"))
            }
            return actors
        }
    }

}