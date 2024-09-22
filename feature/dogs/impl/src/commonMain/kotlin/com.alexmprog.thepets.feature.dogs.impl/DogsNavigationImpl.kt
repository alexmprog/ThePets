package com.alexmprog.thepets.feature.dogs.impl

import cafe.adriel.voyager.core.screen.Screen
import com.alexmprog.thepets.feature.dogs.api.DogsNavigation
import com.alexmprog.thepets.feature.dogs.impl.presentation.DogsScreen

internal class DogsNavigationImpl : DogsNavigation {

    override fun dogsScreen(): Screen = DogsScreen()

}