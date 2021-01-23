package com.example.androidfundamentals2020.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = MovieListDbContract.Actors.TABLE_NAME,
    indices = [Index(MovieListDbContract.Actors.COLUMN_NAME_ID)]
)
data class ActorDbEntity(
    @PrimaryKey
    @ColumnInfo(name = MovieListDbContract.Actors.COLUMN_NAME_ID)
    val id: Long = 0,

    @ColumnInfo(name = MovieListDbContract.Actors.COLUMN_NAME_NAME)
    val name: String = "",

    @ColumnInfo(name = MovieListDbContract.Actors.COLUMN_NAME_PICTURE)
    val picture: String = "",

    @ColumnInfo(name = MovieListDbContract.Actors.COLUMN_NAME_MOVIE_ID)
    val movieId: Long = 0

)