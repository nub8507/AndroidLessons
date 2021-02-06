package com.example.androidfundamentals2020.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = MovieListDbContract.Genres.TABLE_NAME,
    foreignKeys = [ForeignKey(
        entity = MovieDbEntity::class,
        parentColumns = [MovieListDbContract.Movies.COLUMN_NAME_ID],
        childColumns = [MovieListDbContract.Genres.COLUMN_NAME_MOVIE_ID],
        onDelete = ForeignKey.CASCADE
    )]
)
data class GenreDbEntity(

    @ColumnInfo(name = MovieListDbContract.Genres.COLUMN_NAME_ID_ID)
    var id: Long = 0,

    @ColumnInfo(name = MovieListDbContract.Genres.COLUMN_NAME_NAME)
    var name: String = "",

    @ColumnInfo(name = MovieListDbContract.Genres.COLUMN_NAME_MOVIE_ID)
    var movieId: Long = 0,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = MovieListDbContract.Genres.COLUMN_NAME_ID)
    var genreid: Long = 0
)