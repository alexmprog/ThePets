package com.alexmprog.thepets

import androidx.compose.ui.window.ComposeUIViewController
import cafe.adriel.voyager.navigator.Navigator
import com.alexmprog.common.logger.Logger
import com.alexmprog.thepets.core.ui.theme.PetsTheme
import com.alexmprog.thepets.feature.home.api.HomeFeature
import org.koin.compose.koinInject
import org.koin.core.context.startKoin

@Suppress("unused", "FunctionName")
fun MainViewController() = ComposeUIViewController {
    val homeFeature = koinInject<HomeFeature>()
    PetsTheme {
        Navigator(homeFeature.homeScreen())
    }
}

@Suppress("unused")
fun initApp() {
    initKoin()
    Logger.init()
}

private fun initKoin() {
    startKoin {
        modules(appModules)
    }
}
