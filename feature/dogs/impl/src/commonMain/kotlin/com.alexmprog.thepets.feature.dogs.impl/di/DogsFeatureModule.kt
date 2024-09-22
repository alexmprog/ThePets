package com.alexmprog.thepets.feature.dogs.impl.di

import com.alexmprog.thepets.common.dispatchers.CommonIoDispatcher
import com.alexmprog.thepets.feature.dogs.api.domain.repository.DogsRepository
import com.alexmprog.thepets.feature.dogs.api.domain.usecase.DeleteDogUseCase
import com.alexmprog.thepets.feature.dogs.api.domain.usecase.GetDogsUseCase
import com.alexmprog.thepets.feature.dogs.api.domain.usecase.ObserveDogsUseCase
import com.alexmprog.thepets.feature.dogs.api.domain.usecase.SaveDogUseCase
import com.alexmprog.thepets.feature.dogs.impl.DogsNavigationImpl
import com.alexmprog.thepets.feature.dogs.impl.data.network.DogsServiceImpl
import com.alexmprog.thepets.feature.dogs.impl.data.repository.DogsRepositoryImpl
import com.alexmprog.thepets.feature.dogs.impl.presentation.DogsScreenViewModel
import com.alexmprog.thepets.feature.dogs.impl.presentation.SavedDogsViewModel
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dogsFeatureModule = module {
    single<DogsRepository> {
        DogsRepositoryImpl(
            get(),
            get(),
            get<CoroutineDispatcher>(named(CommonIoDispatcher))
        )
    }
    singleOf(::DogsNavigationImpl)
    factoryOf(::DogsServiceImpl)
    factoryOf(::GetDogsUseCase)
    factoryOf(::ObserveDogsUseCase)
    factoryOf(::SaveDogUseCase)
    factoryOf(::DeleteDogUseCase)
    factoryOf(::DogsScreenViewModel)
    factoryOf(::SavedDogsViewModel)
}