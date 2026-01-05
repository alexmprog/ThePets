package com.alexmprog.thepets.core.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.alexmprog.thepets.core.database.dao.CatsDao
import com.alexmprog.thepets.core.database.dao.DogsDao
import com.alexmprog.thepets.core.database.model.CatEntity
import com.alexmprog.thepets.core.database.model.DogEntity

@Database(
    entities = [
        CatEntity::class,
        DogEntity::class,
    ],
    version = DATABASE_VERSION
)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class PetsDatabase : RoomDatabase() {
    abstract fun dogsDao(): DogsDao
    abstract fun catsDao(): CatsDao
}

// The Room compiler generates the `actual` implementations.
@Suppress("KotlinNoActualForExpect")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<PetsDatabase> {
    override fun initialize(): PetsDatabase
}

private const val DATABASE_VERSION = 1