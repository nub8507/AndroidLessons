package com.example.androidfundamentals2020

class MovieActorData(
    val imageResId: Int,
    val name: String
) {

    companion object {
        fun getActorsListData(): List<MovieActorData> {
            val actors = listOf(
                MovieActorData(R.drawable.actor1, "Robert Downey Jr."),
                MovieActorData(R.drawable.actor2, "Chris Evans"),
                MovieActorData(R.drawable.actor3, "Mark Ruffalo"),
                MovieActorData(R.drawable.actor4, "Chris Hemsworth")
            )
            return actors
        }
    }

}