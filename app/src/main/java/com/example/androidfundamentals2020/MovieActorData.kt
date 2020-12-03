package com.example.androidfundamentals2020

class MovieActorData(val image: Int,
                     val name: String
                    )  {

    companion object {
        fun getActorsListData(): ArrayList<MovieActorData> {
            val actors = ArrayList<MovieActorData>()
            actors.apply {
//                add(MovieActorData(R.drawable.actor1, "Robert Downey Jr."))
//                add(MovieActorData(R.drawable.actor2,"Chris Evans"))
//                add(MovieActorData(R.drawable.actor3, "Mark Ruffalo"))
//                add(MovieActorData(R.drawable.actor4, "Chris Hemsworth"))
            }
            return actors
        }
    }

}