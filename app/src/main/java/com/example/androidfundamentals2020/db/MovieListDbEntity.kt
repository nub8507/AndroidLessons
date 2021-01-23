package com.example.androidfundamentals2020.db

import androidx.room.*

@Entity(
    tableName = MovieListDbContract.Movies.TABLE_NAME,
    indices = [Index(MovieListDbContract.Movies.COLUMN_NAME_ID)]
)
data class DbMovieEntity(
    @PrimaryKey
    @ColumnInfo(name = MovieListDbContract.Movies.COLUMN_NAME_ID)
    var id: Long = 0,

    @ColumnInfo(name = MovieListDbContract.Movies.COLUMN_NAME_TITLE)
    var title: String = "",

    @ColumnInfo(name = MovieListDbContract.Movies.COLUMN_NAME_OVERVIEW)
    var overview: String = "",

    @ColumnInfo(name = MovieListDbContract.Movies.COLUMN_NAME_POSTER)
    var poster: String = "",

    @ColumnInfo(name = MovieListDbContract.Movies.COLUMN_NAME_BACKDROP)
    var backdrop: String = "",

    @ColumnInfo(name = MovieListDbContract.Movies.COLUMN_NAME_RATINGS)
    var ratings: Float = 0f,

    @ColumnInfo(name = MovieListDbContract.Movies.COLUMN_NAME_NUMBEROFRATINGS)
    var numberOfRatings: Int = 0,

    @ColumnInfo(name = MovieListDbContract.Movies.COLUMN_NAME_MINIMUMAGE)
    var minimumAge: Int = 0,

    @ColumnInfo(name = MovieListDbContract.Movies.COLUMN_NAME_RUNTIME)
    var runtime: Int = 0,

    @Ignore
    var genres: List<GenreDbEntity> = listOf(),

    @Ignore
    var actors: List<ActorDbEntity> = listOf()
    )