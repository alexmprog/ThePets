package com.alexmprog.thepets.feature.dogs.api

import cafe.adriel.voyager.core.screen.Screen

interface DogsNavigation {

    fun dogsScreen(): Screen

    fun savedDogsScreen(): Screen
}