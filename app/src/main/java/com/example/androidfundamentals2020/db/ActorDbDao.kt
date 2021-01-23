package com.example.androidfundamentals2020.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ActorDbDao {

    @Query("SELECT * FROM Actors")
    suspend fun getAll(): List<ActorDbEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dbActor: ActorDbEntity)
}