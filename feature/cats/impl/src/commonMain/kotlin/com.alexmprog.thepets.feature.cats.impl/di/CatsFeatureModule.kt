package com.alexmprog.thepets.feature.cats.impl.di

import com.alexmprog.thepets.feature.cats.api.CatsFeature
import com.alexmprog.thepets.feature.cats.impl.CatsFeatureImpl
import com.alexmprog.thepets.feature.cats.impl.presentation.CatsScreenViewModel
import com.alexmprog.thepets.feature.cats.impl.presentation.SavedCatsScreenViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val catsFeatureModule
    get() = module {
        singleOf(::CatsFeatureImpl) bind CatsFeature::class
        factoryOf(::CatsScreenViewModel)
        factoryOf(::SavedCatsScreenViewModel)
    }