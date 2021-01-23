package com.example.androidfundamentals2020.db

import androidx.room.*


@Dao
interface DbMoviesDao {

    @Query("SELECT * FROM Movies ORDER BY ratings DESC")
    suspend fun getAll(): List<DbMovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dbMovie: DbMovieEntity)

    @Update
    suspend fun update(dbMovie: DbMovieEntity)

    @Query("SELECT * FROM Movies WHERE _id = :id")
    fun getById(id: Long): DbMovieEntity?
}