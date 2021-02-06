package com.example.androidfundamentals2020.db

import androidx.room.*
import com.example.androidfundamentals2020.data.Movie

@Dao
interface MoviesListDbDao {

    @Transaction
    @Query("SELECT * FROM Movies ORDER BY ratings DESC")
    suspend fun getAll(): List<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dbMovie: MovieDbEntity)

    @Transaction
    @Query("SELECT * FROM Movies WHERE _id = :id")
    fun getById(id: Long): Movie?
}