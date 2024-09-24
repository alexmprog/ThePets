package com.alexmprog.thepets.feature.dogs.impl.presentation

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.alexmprog.thepets.domain.dogs.model.Dog
import com.alexmprog.thepets.domain.dogs.usecase.DeleteDogUseCase
import com.alexmprog.thepets.domain.dogs.usecase.ObserveDogsUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

internal data class SavedDogsScreenState(
    val isLoading: Boolean = false,
    val dogs: List<Dog> = emptyList()
)

internal class SavedDogsViewModel(
    private val observeDogsUseCase: ObserveDogsUseCase,
    private val deleteDogUseCase: DeleteDogUseCase
) : ScreenModel {

    val state: StateFlow<SavedDogsScreenState> = observeDogsUseCase()
        .map { SavedDogsScreenState(false, it) }
        .stateIn(
            scope = screenModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = SavedDogsScreenState(isLoading = true),
        )

    fun delete(dog: Dog) {
        screenModelScope.launch {
            deleteDogUseCase(dog)
        }
    }

}