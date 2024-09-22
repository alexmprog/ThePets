package com.alexmprog.thepets.feature.dogs.impl

import cafe.adriel.voyager.core.screen.Screen
import com.alexmprog.thepets.feature.dogs.api.DogsFeature
import com.alexmprog.thepets.feature.dogs.impl.presentation.DogsScreen

internal class DogsFeatureImpl : DogsFeature {

    override fun dogsScreen(): Screen = DogsScreen()

}