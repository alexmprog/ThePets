package com.alexmprog.thepets.feature.home.impl.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.alexmprog.thepets.feature.cats.api.CatsFeature
import com.alexmprog.thepets.feature.dogs.api.DogsFeature
import org.koin.compose.koinInject

internal class HomeScreen : Screen {

    @Composable
    override fun Content() {
        HomeScreenContent()
    }
}

@Composable
internal fun HomeScreenContent() {
    val navigator = LocalNavigator.currentOrThrow
    val dogsFeature = koinInject<DogsFeature>()
    val catsFeature = koinInject<CatsFeature>()
    Scaffold { innerPaddings ->
        Column(modifier = Modifier.padding(innerPaddings).fillMaxSize()) {
            Button(onClick = {
                navigator.push(catsFeature.catsScreen())
            }) {
                Text("Cats")
            }
            Button(onClick = {
                navigator.push(dogsFeature.dogsScreen())
            }) {
                Text("Dogs")
            }
        }
    }
}