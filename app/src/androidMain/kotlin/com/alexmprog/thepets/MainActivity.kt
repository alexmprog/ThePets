package com.alexmprog.thepets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cafe.adriel.voyager.navigator.Navigator
import com.alexmprog.thepets.core.ui.theme.PetsTheme
import com.alexmprog.thepets.feature.home.api.HomeFeature
import org.koin.compose.koinInject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val homeFeature = koinInject<HomeFeature>()
            PetsTheme {
                Navigator(homeFeature.homeScreen())
            }
        }
    }
}