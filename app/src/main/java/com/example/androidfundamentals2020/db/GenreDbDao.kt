package com.example.androidfundamentals2020.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GenreDbDao {

    @Query("SELECT * FROM Genres")
    suspend fun getAll(): List<GenreDbEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dbGenre: GenreDbEntity)
}