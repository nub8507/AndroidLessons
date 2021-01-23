package com.example.androidfundamentals2020.data

import androidx.room.Embedded
import androidx.room.Relation
import com.example.androidfundamentals2020.db.ActorDbEntity
import com.example.androidfundamentals2020.db.GenreDbEntity
import com.example.androidfundamentals2020.db.MovieDbEntity
import com.example.androidfundamentals2020.db.MovieListDbContract

data class Movie(

    @Embedded
    var movieData: MovieDbEntity = MovieDbEntity(),

    @Relation(
        parentColumn = MovieListDbContract.Movies.COLUMN_NAME_ID,
        entityColumn = MovieListDbContract.Genres.COLUMN_NAME_MOVIE_ID
    )
    var genres: List<GenreDbEntity> = listOf(),

    @Relation(
        parentColumn = MovieListDbContract.Movies.COLUMN_NAME_ID,
        entityColumn = MovieListDbContract.Actors.COLUMN_NAME_MOVIE_ID
    )
    var actors: List<ActorDbEntity> = listOf()
)