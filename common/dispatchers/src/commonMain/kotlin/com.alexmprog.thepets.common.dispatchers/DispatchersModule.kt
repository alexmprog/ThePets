package com.alexmprog.thepets.common.dispatchers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val CommonIoDispatcher = "IoDispatcher"
const val CommonDefaultDispatcher = "DefaultDispatcher"

val dispatchersModule = module {
    single<CoroutineDispatcher>((named(CommonIoDispatcher))) { Dispatchers.IO }
    single<CoroutineDispatcher>((named(CommonDefaultDispatcher))) { Dispatchers.Default }
}