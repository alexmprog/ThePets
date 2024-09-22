package com.alexmprog.thepets.feature.home.impl

import cafe.adriel.voyager.core.screen.Screen
import com.alexmprog.thepets.feature.home.api.HomeFeature
import com.alexmprog.thepets.feature.home.impl.presentation.HomeScreen

internal class HomeFeatureImpl : HomeFeature {

    override fun homeScreen(): Screen = HomeScreen()
}