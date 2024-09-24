package com.alexmprog.thepets.domain.dogs.di

import com.alexmprog.thepets.domain.dogs.usecase.DeleteDogUseCase
import com.alexmprog.thepets.domain.dogs.usecase.GetDogsUseCase
import com.alexmprog.thepets.domain.dogs.usecase.ObserveDogsUseCase
import com.alexmprog.thepets.domain.dogs.usecase.SaveDogUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val dogsDomainModule
    get() = module {
        factoryOf(::GetDogsUseCase)
        factoryOf(::ObserveDogsUseCase)
        factoryOf(::SaveDogUseCase)
        factoryOf(::DeleteDogUseCase)
    }