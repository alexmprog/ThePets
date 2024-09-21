package com.alexmprog.thepets.core.database

import com.alexmprog.thepets.common.dispatchers.CommonIoDispatcher
import com.alexmprog.thepets.core.database.dao.DogsDao
import com.alexmprog.thepets.core.database.dao.DogsDaoImpl
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.core.module.Module
import org.koin.core.qualifier.named

expect fun platformModule(): Module

val databaseModule = platformModule().apply {
    factory<DogsDao> {
        DogsDaoImpl(
            get<PetsDatabase>().dogQueries,
            get<CoroutineDispatcher>(named(CommonIoDispatcher))
        )
    }
}