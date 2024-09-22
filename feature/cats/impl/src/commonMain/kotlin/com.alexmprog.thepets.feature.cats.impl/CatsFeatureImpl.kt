package com.alexmprog.thepets.feature.cats.impl

import cafe.adriel.voyager.core.screen.Screen
import com.alexmprog.thepets.feature.cats.api.CatsFeature
import com.alexmprog.thepets.feature.cats.impl.presentation.CatsScreen

class CatsFeatureImpl : CatsFeature {

    override fun catsScreen(): Screen = CatsScreen()

}