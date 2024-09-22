package com.alexmprog.thepets.feature.dogs.impl.presentation

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.alexmprog.thepets.core.utils.onError
import com.alexmprog.thepets.core.utils.onSuccess
import com.alexmprog.thepets.feature.dogs.api.domain.model.Dog
import com.alexmprog.thepets.feature.dogs.api.domain.usecase.GetDogsUseCase
import com.alexmprog.thepets.feature.dogs.api.domain.usecase.SaveDogUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal data class DogsScreenState(
    val isLoading: Boolean = false,
    val dogs: List<Dog> = emptyList()
)

internal class DogsScreenViewModel(
    private val getDogsUseCase: GetDogsUseCase,
    private val saveDogUseCase: SaveDogUseCase
) : ScreenModel {

    private val _state = MutableStateFlow(DogsScreenState())
    val state: StateFlow<DogsScreenState> = _state.asStateFlow()

    init {
        refresh()
    }

    fun refresh() {
        screenModelScope.launch {
            getDogsUseCase(9)
                .onSuccess { dogs ->
                    _state.update { it.copy(dogs = dogs) }
                }.onError {

                }
        }
    }

    fun save(dog: Dog) {
        screenModelScope.launch {
            saveDogUseCase(dog)
            _state.update {
                val items = it.dogs.toMutableList()
                items.remove(dog)
                it.copy(dogs = items)
            }
        }
    }
}