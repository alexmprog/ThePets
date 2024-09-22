package com.alexmprog.thepets.feature.cats.impl.di

import com.alexmprog.thepets.common.dispatchers.CommonIoDispatcher
import com.alexmprog.thepets.feature.cats.api.CatsFeature
import com.alexmprog.thepets.feature.cats.api.domain.repository.CatsRepository
import com.alexmprog.thepets.feature.cats.api.domain.usecase.DeleteCatUseCase
import com.alexmprog.thepets.feature.cats.api.domain.usecase.GetCatsUseCase
import com.alexmprog.thepets.feature.cats.api.domain.usecase.ObserveCatsUseCase
import com.alexmprog.thepets.feature.cats.api.domain.usecase.SaveCatUseCase
import com.alexmprog.thepets.feature.cats.impl.CatsFeatureImpl
import com.alexmprog.thepets.feature.cats.impl.data.network.CatsService
import com.alexmprog.thepets.feature.cats.impl.data.network.CatsServiceImpl
import com.alexmprog.thepets.feature.cats.impl.data.repository.CatsRepositoryImpl
import com.alexmprog.thepets.feature.cats.impl.presentation.CatsScreenViewModel
import com.alexmprog.thepets.feature.cats.impl.presentation.SavedCatsScreenViewModel
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val catsFeatureModule
    get() = module {
        single<CatsRepository> {
            CatsRepositoryImpl(
                get(),
                get(),
                get<CoroutineDispatcher>(named(CommonIoDispatcher))
            )
        }
        singleOf(::CatsFeatureImpl) bind CatsFeature::class
        factoryOf(::CatsServiceImpl) bind CatsService::class
        factoryOf(::GetCatsUseCase)
        factoryOf(::ObserveCatsUseCase)
        factoryOf(::SaveCatUseCase)
        factoryOf(::DeleteCatUseCase)
        factoryOf(::CatsScreenViewModel)
        factoryOf(::SavedCatsScreenViewModel)
    }