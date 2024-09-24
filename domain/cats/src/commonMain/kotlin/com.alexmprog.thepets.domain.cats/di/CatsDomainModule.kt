package com.alexmprog.thepets.domain.cats.di

import com.alexmprog.thepets.domain.cats.usecase.DeleteCatUseCase
import com.alexmprog.thepets.domain.cats.usecase.GetCatsUseCase
import com.alexmprog.thepets.domain.cats.usecase.ObserveCatsUseCase
import com.alexmprog.thepets.domain.cats.usecase.SaveCatUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val catsDomainModule
    get() = module {
        factoryOf(::GetCatsUseCase)
        factoryOf(::ObserveCatsUseCase)
        factoryOf(::SaveCatUseCase)
        factoryOf(::DeleteCatUseCase)
    }