package com.alexmprog.thepets.feature.dogs.impl.di

import com.alexmprog.thepets.common.dispatchers.CommonIoDispatcher
import com.alexmprog.thepets.feature.dogs.api.DogsFeature
import com.alexmprog.thepets.feature.dogs.api.domain.usecase.DeleteDogUseCase
import com.alexmprog.thepets.feature.dogs.api.domain.usecase.GetDogsUseCase
import com.alexmprog.thepets.feature.dogs.api.domain.usecase.ObserveDogsUseCase
import com.alexmprog.thepets.feature.dogs.api.domain.usecase.SaveDogUseCase
import com.alexmprog.thepets.feature.dogs.impl.DogsFeatureImpl
import com.alexmprog.thepets.feature.dogs.impl.data.network.DogsService
import com.alexmprog.thepets.feature.dogs.impl.data.network.DogsServiceImpl
import com.alexmprog.thepets.feature.dogs.impl.data.repository.DogsRepositoryImpl
import com.alexmprog.thepets.feature.dogs.impl.domain.repository.DogsRepository
import com.alexmprog.thepets.feature.dogs.impl.domain.usecase.DeleteDogUseCaseImpl
import com.alexmprog.thepets.feature.dogs.impl.domain.usecase.GetDogsUseCaseImpl
import com.alexmprog.thepets.feature.dogs.impl.domain.usecase.ObserveDogsUseCaseImpl
import com.alexmprog.thepets.feature.dogs.impl.domain.usecase.SaveDogUseCaseImpl
import com.alexmprog.thepets.feature.dogs.impl.presentation.DogsScreenModel
import com.alexmprog.thepets.feature.dogs.impl.presentation.SavedDogsScreenModel
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val dogsFeatureModule
    get() = module {
        includes(dogsDataModule, dogsDomainModule, dogsPresentationModule)
    }

private val dogsDomainModule
    get() = module {
        factoryOf(::GetDogsUseCaseImpl) bind GetDogsUseCase::class
        factoryOf(::ObserveDogsUseCaseImpl) bind ObserveDogsUseCase::class
        factoryOf(::SaveDogUseCaseImpl) bind SaveDogUseCase::class
        factoryOf(::DeleteDogUseCaseImpl) bind DeleteDogUseCase::class
    }

private val dogsDataModule
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

private val dogsPresentationModule
    get() = module {
        singleOf(::DogsFeatureImpl) bind DogsFeature::class
        factoryOf(::DogsScreenModel)
        factoryOf(::SavedDogsScreenModel)
    }