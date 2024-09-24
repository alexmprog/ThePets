package com.alexmprog.thepets

import com.alexmprog.thepets.common.dispatchers.dispatchersModule
import com.alexmprog.thepets.core.database.databaseModule
import com.alexmprog.thepets.data.cats.di.catsDataModule
import com.alexmprog.thepets.data.dogs.di.dogsDataModule
import com.alexmprog.thepets.domain.cats.di.catsDomainModule
import com.alexmprog.thepets.domain.dogs.di.dogsDomainModule
import com.alexmprog.thepets.feature.cats.impl.di.catsFeatureModule
import com.alexmprog.thepets.feature.dogs.impl.di.dogsFeatureModule
import com.alexmprog.thepets.feature.home.impl.di.homeFeatureModule
import com.alexmprog.thepets.core.network.networkModule

private val commonModules
    get() = listOf(
        dispatchersModule
    )

private val coreModules
    get() = listOf(
        networkModule,
        databaseModule
    )

private val dataModules
    get() = listOf(
        catsDataModule,
        dogsDataModule
    )

private val domainModules
    get() = listOf(
        catsDomainModule,
        dogsDomainModule
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
        dataModules,
        domainModules,
        featureModules
    ).flatten()
