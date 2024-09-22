package com.alexmprog.thepets.core.database

import com.alexmprog.thepets.core.database.dao.CatsDao
import com.alexmprog.thepets.core.database.dao.DogsDao


val databaseModule
    get() = platformDatabaseModule(fileName = "pets.db")
        .apply {
            single<CatsDao> { get<PetsDatabase>().catsDao() }
            single<DogsDao> { get<PetsDatabase>().dogsDao() }
        }