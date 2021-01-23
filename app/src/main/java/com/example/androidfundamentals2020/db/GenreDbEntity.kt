package com.example.androidfundamentals2020.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = MovieListDbContract.Genres.TABLE_NAME,
    indices = [Index(MovieListDbContract.Genres.COLUMN_NAME_ID)]
)
data class GenreDbEntity(

    @PrimaryKey
    @ColumnInfo(name = MovieListDbContract.Genres.COLUMN_NAME_ID)
    val id: Long = 0,

    @ColumnInfo(name = MovieListDbContract.Genres.COLUMN_NAME_NAME)
    val name: String = ""
)