package com.alexmprog.thepets.core.database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.alexmprog.thepets.common.dispatchers.CommonIoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal actual fun platformDatabaseModule(
    fileName: String,
): Module = module(createdAtStart = true) {
    single<PetsDatabase> {
        getDatabase(
            get(),
            get<CoroutineDispatcher>(named(CommonIoDispatcher)),
            fileName
        )
    }
}

private fun getDatabase(
    context: Context,
    coroutineDispatcher: CoroutineDispatcher,
    fileName: String,
): PetsDatabase = Room
    .databaseBuilder<PetsDatabase>(
        context = context.applicationContext,
        name = context.applicationContext.getDatabasePath(fileName).absolutePath
    )
    .setDriver(BundledSQLiteDriver())
    .setQueryCoroutineContext(coroutineDispatcher)
    .build()
