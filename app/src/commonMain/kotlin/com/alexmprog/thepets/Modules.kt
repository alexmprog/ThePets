package com.alexmprog.thepets

import com.alexmprog.thepets.common.dispatchers.dispatchersModule
import com.alexmprog.thepets.core.database.databaseModule
import com.alexmprog.thepets.feature.cats.impl.di.catsFeatureModule
import com.alexmprog.thepets.feature.dogs.impl.di.dogsFeatureModule
import com.alexmprog.thepets.feature.home.impl.di.homeFeatureModule
import com.alexprog.thepets.core.network.networkModule

private val commonModules
    get() = listOf(
        dispatchersModule
    )

private val coreModules
    get() = listOf(
        networkModule,
        databaseModule
    )

private val featureModules
    get() = listOf(
        catsFeatureModule,
        dogsFeatureModule,
        homeFeatureModule
    )

val appModules
    get() = listOf(
        commonModules,
        coreModules,
        featureModules,
    ).flatten()
