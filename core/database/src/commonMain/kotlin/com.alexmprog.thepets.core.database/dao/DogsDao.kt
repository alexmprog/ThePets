package com.alexmprog.thepets.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alexmprog.thepets.core.database.model.DogEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DogsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: DogEntity)

    @Query("DELETE FROM DogEntity WHERE id = :id")
    suspend fun delete(id: String)

    @Query("SELECT * FROM DogEntity")
    fun observe(): Flow<List<DogEntity>>
}
