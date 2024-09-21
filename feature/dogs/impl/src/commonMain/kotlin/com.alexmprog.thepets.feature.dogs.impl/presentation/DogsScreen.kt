package com.alexmprog.thepets.feature.dogs.impl.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import coil3.compose.AsyncImage
import com.alexmprog.thepets.common.logger.Logger

internal class DogsScreen : Screen {

    @Composable
    override fun Content() {
        Logger.log("DogsScreenContent","Content")
        val viewModel = koinScreenModel<DogsScreenViewModel>()
        val state by viewModel.state.collectAsState()
        DogsScreenContent(state)
    }
}

@Composable
internal fun DogsScreenContent(state: DogsScreenState) {
    Logger.log("DogsScreenContent","state=$state")
    Surface(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.dogs) {
                OutlinedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize()
                        .clickable {}
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        AsyncImage(
                            model = it.url,
                            contentDescription = it.url,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(50.dp)
                        )
                    }
                }
            }
        }
    }
}