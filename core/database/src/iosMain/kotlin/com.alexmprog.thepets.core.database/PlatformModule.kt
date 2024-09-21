package com.alexmprog.thepets.core.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import org.koin.dsl.module

internal actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(PetsDatabase.Schema, "pets.db")
    }
}

actual fun platformModule() = module {
    single { createDatabase(DatabaseDriverFactory()) }
}