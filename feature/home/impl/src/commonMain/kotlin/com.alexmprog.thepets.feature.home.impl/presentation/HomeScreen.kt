package com.alexmprog.thepets.feature.home.impl.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.alexmprog.thepets.feature.cats.api.CatsFeature
import com.alexmprog.thepets.feature.dogs.api.DogsFeature
import com.alexmprog.thepets.feature.home.impl.Res
import com.alexmprog.thepets.feature.home.impl.ic_home
import com.alexmprog.thepets.feature.home.impl.show_cats
import com.alexmprog.thepets.feature.home.impl.show_dogs
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
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
        Column(
            modifier = Modifier.padding(innerPaddings).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painterResource(Res.drawable.ic_home), null,
                modifier = Modifier.size(300.dp)
            )
            Row {
                Button(onClick = { navigator.push(catsFeature.catsScreen()) }) {
                    Text(stringResource(Res.string.show_cats))
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = { navigator.push(dogsFeature.dogsScreen()) }) {
                    Text(stringResource(Res.string.show_dogs))
                }
            }
        }
    }
}