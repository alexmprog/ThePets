package com.alexmprog.thepets

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.window.ComposeUIViewController
import cafe.adriel.voyager.navigator.Navigator
import com.alexmprog.thepets.common.logger.Logger
import com.alexmprog.thepets.feature.home.api.HomeFeature
import org.koin.compose.koinInject
import org.koin.core.context.startKoin

@Suppress("unused", "FunctionName")
fun MainViewController() = ComposeUIViewController {
    val homeFeature = koinInject<HomeFeature>()
    MaterialTheme {
        Navigator(
            homeFeature.homeScreen()
        )
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
