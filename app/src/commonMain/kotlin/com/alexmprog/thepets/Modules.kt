package com.alexmprog.thepets

import com.alexmprog.thepets.common.dispatchers.dispatchersModule
import com.alexmprog.thepets.core.database.databaseModule
import com.alexmprog.thepets.feature.dogs.impl.di.dogsFeatureModule
import com.alexprog.thepets.core.network.networkModule

private val coreModules
    get() = listOf(
        networkModule,
        databaseModule,
        dispatchersModule
    )


private val featureModules
    get() = listOf(
        dogsFeatureModule,
    )

val appModules
    get() = listOf(
        coreModules,
        featureModules,
    ).flatten()
