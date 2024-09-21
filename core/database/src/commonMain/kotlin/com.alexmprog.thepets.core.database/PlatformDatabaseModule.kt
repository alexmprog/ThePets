package com.alexmprog.thepets.core.database

import org.koin.core.module.Module

internal expect fun platformDatabaseModule(fileName: String): Module
