package com.alexmprog.thepets.core.database

import app.cash.sqldelight.db.SqlDriver

internal expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}

internal fun createDatabase(driverFactory: DatabaseDriverFactory): PetsDatabase {
    val driver = driverFactory.createDriver()
    return PetsDatabase(driver)
}

