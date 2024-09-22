package com.alexmprog.thepets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import cafe.adriel.voyager.navigator.Navigator
import com.alexmprog.thepets.feature.cats.api.CatsFeature
import com.alexmprog.thepets.feature.dogs.api.DogsFeature
import org.koin.compose.koinInject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val homeFeature = koinInject<CatsFeature>()
            MaterialTheme {
                Navigator(homeFeature.catsScreen())
            }
        }
    }
}