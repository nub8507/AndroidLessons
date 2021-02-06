package com.example.androidfundamentals2020.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = MovieListDbContract.Actors.TABLE_NAME,
    foreignKeys = [ForeignKey(
        entity = MovieDbEntity::class,
        parentColumns = [MovieListDbContract.Movies.COLUMN_NAME_ID],
        childColumns = [MovieListDbContract.Actors.COLUMN_NAME_MOVIE_ID],
        onDelete = ForeignKey.CASCADE
    )]
)
data class ActorDbEntity(

    @ColumnInfo(name = MovieListDbContract.Actors.COLUMN_NAME_ID_ID)
    var id: Long = 0,

    @ColumnInfo(name = MovieListDbContract.Actors.COLUMN_NAME_NAME)
    var name: String = "",

    @ColumnInfo(name = MovieListDbContract.Actors.COLUMN_NAME_PICTURE)
    var picture: String = "",

    @ColumnInfo(name = MovieListDbContract.Actors.COLUMN_NAME_MOVIE_ID)
    var movieId: Long = 0,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = MovieListDbContract.Actors.COLUMN_NAME_ID)
    var genreId: Long = 0
)