package com.alexmprog.thepets.core.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun PetsTheme(content: @Composable () -> Unit) {
    MaterialTheme { content() }
}