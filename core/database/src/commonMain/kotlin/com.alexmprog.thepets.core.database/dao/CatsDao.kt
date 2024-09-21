package com.alexmprog.thepets.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alexmprog.thepets.core.database.model.CatEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CatsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: CatEntity)

    @Query("DELETE FROM CatEntity WHERE url = :url")
    suspend fun delete(url: String)

    @Query("SELECT * FROM CatEntity")
    fun observe(): Flow<List<CatEntity>>
}