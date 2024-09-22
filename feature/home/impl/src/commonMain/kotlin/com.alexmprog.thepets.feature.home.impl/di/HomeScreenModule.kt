package com.alexmprog.thepets.feature.home.impl.di

import com.alexmprog.thepets.feature.home.api.HomeFeature
import com.alexmprog.thepets.feature.home.impl.HomeFeatureImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val homeFeatureModule
    get() = module {
        singleOf(::HomeFeatureImpl) bind HomeFeature::class
    }