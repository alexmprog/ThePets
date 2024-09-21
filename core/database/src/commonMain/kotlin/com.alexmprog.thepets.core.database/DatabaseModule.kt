package com.alexmprog.thepets.core.database

import com.alexmprog.thepets.core.database.dao.DogsDao


val databaseModule
    get() = platformDatabaseModule(fileName = "pets.db")
        .apply {
            single<DogsDao> { get<PetsDatabase>().dogsDao() }
        }