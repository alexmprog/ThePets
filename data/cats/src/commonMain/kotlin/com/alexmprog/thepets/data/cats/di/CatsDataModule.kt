package com.alexmprog.thepets.data.cats.di

import com.alexmprog.thepets.common.dispatchers.CommonIoDispatcher
import com.alexmprog.thepets.data.cats.network.CatsService
import com.alexmprog.thepets.data.cats.network.CatsServiceImpl
import com.alexmprog.thepets.data.cats.repository.CatsRepositoryImpl
import com.alexmprog.thepets.domain.cats.repository.CatsRepository
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.core.module.dsl.factoryOf
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val catsDataModule
    get() = module {
        single<CatsRepository> {
            CatsRepositoryImpl(
                get(),
                get(),
                get<CoroutineDispatcher>(named(CommonIoDispatcher))
            )
        }
        factoryOf(::CatsServiceImpl) bind CatsService::class
    }