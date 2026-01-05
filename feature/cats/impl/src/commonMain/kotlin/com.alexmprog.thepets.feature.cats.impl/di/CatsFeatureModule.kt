package com.alexmprog.thepets.feature.cats.impl.di

import com.alexmprog.thepets.common.dispatchers.CommonIoDispatcher
import com.alexmprog.thepets.feature.cats.api.CatsFeature
import com.alexmprog.thepets.feature.cats.api.domain.usecase.DeleteCatUseCase
import com.alexmprog.thepets.feature.cats.api.domain.usecase.GetCatsUseCase
import com.alexmprog.thepets.feature.cats.api.domain.usecase.ObserveCatsUseCase
import com.alexmprog.thepets.feature.cats.api.domain.usecase.SaveCatUseCase
import com.alexmprog.thepets.feature.cats.impl.CatsFeatureImpl
import com.alexmprog.thepets.feature.cats.impl.data.repository.CatsRepositoryImpl
import com.alexmprog.thepets.feature.cats.impl.data.network.CatsService
import com.alexmprog.thepets.feature.cats.impl.data.network.CatsServiceImpl
import com.alexmprog.thepets.feature.cats.impl.domain.repository.CatsRepository
import com.alexmprog.thepets.feature.cats.impl.domain.usecase.DeleteCatUseCaseImpl
import com.alexmprog.thepets.feature.cats.impl.domain.usecase.GetCatsUseCaseImpl
import com.alexmprog.thepets.feature.cats.impl.domain.usecase.ObserveCatsUseCaseImpl
import com.alexmprog.thepets.feature.cats.impl.domain.usecase.SaveCatUseCaseImpl
import com.alexmprog.thepets.feature.cats.impl.presentation.CatsScreenModel
import com.alexmprog.thepets.feature.cats.impl.presentation.SavedCatsScreenModel
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val catsFeatureModule
    get() = module {
        includes(catsDataModule, catsDomainModule, catsPresentationModule)
    }

private val catsDomainModule
    get() = module {
        factoryOf(::GetCatsUseCaseImpl) bind GetCatsUseCase::class
        factoryOf(::ObserveCatsUseCaseImpl) bind ObserveCatsUseCase::class
        factoryOf(::SaveCatUseCaseImpl) bind SaveCatUseCase::class
        factoryOf(::DeleteCatUseCaseImpl) bind DeleteCatUseCase::class
    }

private val catsDataModule
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

private val catsPresentationModule
    get() = module {
        singleOf(::CatsFeatureImpl) bind CatsFeature::class
        factoryOf(::CatsScreenModel)
        factoryOf(::SavedCatsScreenModel)
    }