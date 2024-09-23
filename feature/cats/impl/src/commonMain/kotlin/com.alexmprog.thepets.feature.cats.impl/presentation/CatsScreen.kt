package com.alexmprog.thepets.feature.cats.impl.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import coil3.compose.AsyncImage
import com.alexmprog.thepets.feature.cats.api.domain.model.Cat
import com.alexmprog.thepets.feature.cats.impl.Res
import com.alexmprog.thepets.feature.cats.impl.cats
import org.jetbrains.compose.resources.stringResource

internal class CatsScreen : Screen {

    @Composable
    override fun Content() {
        val viewModel = koinScreenModel<CatsScreenViewModel>()
        val state by viewModel.state.collectAsState()
        CatsScreenContent(
            state,
            onRefreshClick = { viewModel.refresh() },
            onCatClick = { viewModel.save(it) })
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
internal fun CatsScreenContent(
    state: CatsScreenState,
    onRefreshClick: () -> Unit,
    onCatClick: (Cat) -> Unit
) {
    val navigator = LocalNavigator.currentOrThrow
    Scaffold(topBar = {
        TopAppBar(title = { Text(stringResource(Res.string.cats)) },
            navigationIcon = {
                IconButton(onClick = { navigator.pop() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null
                    )
                }
            },
            actions = {
                IconButton(onClick = { onRefreshClick() }) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = null
                    )
                }
                IconButton(onClick = {
                    navigator.push(SavedCatsScreen())
                }) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = null
                    )
                }
            })
    }) { innerPaddings ->
        BoxWithConstraints(modifier = Modifier.padding(innerPaddings).fillMaxSize()) {
            val width = maxWidth
            val height = maxHeight
            val count = 3
            LazyVerticalGrid(columns = GridCells.Fixed(count)) {
                items(state.cats, key = { it.id }) {
                    OutlinedCard(
                        modifier = Modifier
                            .wrapContentSize()
                            .animateItemPlacement()
                            .clickable { onCatClick(it) }
                    ) {
                        AsyncImage(
                            model = it.url,
                            contentDescription = it.url,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(width / count, height / count)
                        )
                    }
                }
            }
        }
    }
}