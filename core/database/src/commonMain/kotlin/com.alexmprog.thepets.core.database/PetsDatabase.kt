package com.alexmprog.thepets.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
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
abstract class PetsDatabase : RoomDatabase() {
    abstract fun dogsDao(): DogsDao
    abstract fun catsDao(): CatsDao
}

private const val DATABASE_VERSION = 1