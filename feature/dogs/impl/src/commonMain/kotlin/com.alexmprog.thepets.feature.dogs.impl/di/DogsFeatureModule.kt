package com.alexmprog.thepets.feature.dogs.impl.di

import com.alexmprog.thepets.feature.dogs.api.DogsFeature
import com.alexmprog.thepets.feature.dogs.impl.DogsFeatureImpl
import com.alexmprog.thepets.feature.dogs.impl.presentation.DogsScreenModel
import com.alexmprog.thepets.feature.dogs.impl.presentation.SavedDogsScreenModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dogsFeatureModule = module {
    singleOf(::DogsFeatureImpl) bind DogsFeature::class
    factoryOf(::DogsScreenModel)
    factoryOf(::SavedDogsScreenModel)
}