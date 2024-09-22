package com.alexmprog.thepets

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.window.ComposeUIViewController
import cafe.adriel.voyager.navigator.Navigator
import com.alexmprog.thepets.common.logger.Logger
import com.alexmprog.thepets.feature.cats.api.CatsFeature
import com.alexmprog.thepets.feature.dogs.api.DogsFeature
import org.koin.compose.koinInject
import org.koin.core.context.startKoin

@Suppress("unused", "FunctionName")
fun MainViewController() = ComposeUIViewController {
    val homeFeature = koinInject<CatsFeature>()
    MaterialTheme {
        Navigator(
            homeFeature.catsScreen()
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
