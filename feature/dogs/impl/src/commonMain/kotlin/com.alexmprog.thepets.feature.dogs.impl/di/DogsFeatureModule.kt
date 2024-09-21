package com.alexmprog.thepets.feature.dogs.impl.di

import com.alexmprog.thepets.feature.dogs.api.DogsNavigation
import com.alexmprog.thepets.feature.dogs.api.domain.repository.DogsRepository
import com.alexmprog.thepets.feature.dogs.api.domain.usecase.GetDogsUseCase
import com.alexmprog.thepets.feature.dogs.impl.DogsNavigationImpl
import com.alexmprog.thepets.feature.dogs.impl.data.network.DogsService
import com.alexmprog.thepets.feature.dogs.impl.data.network.DogsServiceImpl
import com.alexmprog.thepets.feature.dogs.impl.data.repository.DogsRepositoryImpl
import com.alexmprog.thepets.feature.dogs.impl.presentation.DogsScreenViewModel
import org.koin.dsl.module

val dogsFeatureModule = module {
    single<DogsNavigation> { DogsNavigationImpl() }
    single<DogsRepository> { DogsRepositoryImpl(get(), get()) }
    factory <DogsService> { DogsServiceImpl(get()) }
    factory { GetDogsUseCase(get()) }
    factory { DogsScreenViewModel(get()) }
}