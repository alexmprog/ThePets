package com.alexmprog.thepets.core.database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.alexmprog.thepets.common.dispatchers.CommonIoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import platform.Foundation.NSHomeDirectory

internal actual fun platformDatabaseModule(
    fileName: String,
): Module = module {
    single<PetsDatabase>(createdAtStart = true) {
        getDatabase(
            get<CoroutineDispatcher>(named(CommonIoDispatcher)),
            fileName
        )
    }
}

private fun getDatabase(
    coroutineDispatcher: CoroutineDispatcher,
    fileName: String,
): PetsDatabase = Room
    .databaseBuilder<PetsDatabase>(
        name = NSHomeDirectory() + "/$fileName",
        factory = { PetsDatabase::class.instantiateImpl() }
    )
    .setDriver(BundledSQLiteDriver())
    .setQueryCoroutineContext(coroutineDispatcher)
    .build()
