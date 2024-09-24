package com.alexmprog.thepets.data.dogs.di

import com.alexmprog.thepets.common.dispatchers.CommonIoDispatcher
import com.alexmprog.thepets.data.dogs.network.DogsService
import com.alexmprog.thepets.data.dogs.network.DogsServiceImpl
import com.alexmprog.thepets.data.dogs.repository.DogsRepositoryImpl
import com.alexmprog.thepets.domain.dogs.repository.DogsRepository
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.core.module.dsl.factoryOf
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val dogsDataModule
    get() = module {
        single<DogsRepository> {
            DogsRepositoryImpl(
                get(),
                get(),
                get<CoroutineDispatcher>(named(CommonIoDispatcher))
            )
        }
        factoryOf(::DogsServiceImpl) bind DogsService::class
    }