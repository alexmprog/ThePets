package com.alexmprog.thepets.core.database

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import org.koin.dsl.module

internal actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(PetsDatabase.Schema, context, "pets.db")
    }
}

actual fun platformModule() = module {
    single { createDatabase(DatabaseDriverFactory(get())) }
}