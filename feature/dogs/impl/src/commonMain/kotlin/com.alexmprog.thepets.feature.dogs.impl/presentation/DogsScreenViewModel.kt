package com.alexmprog.thepets.feature.dogs.impl.presentation

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.alexmprog.thepets.core.utils.onSuccess
import com.alexmprog.thepets.feature.dogs.api.domain.model.Dog
import com.alexmprog.thepets.feature.dogs.api.domain.usecase.GetDogsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal data class DogsScreenState(
    val isLoading: Boolean = false,
    val dogs: List<Dog> = emptyList()
)

internal class DogsScreenViewModel(private val getDogsUseCase: GetDogsUseCase) : ScreenModel {

    private val _state = MutableStateFlow(DogsScreenState())
    val state: StateFlow<DogsScreenState> = _state.asStateFlow()

    init {
        screenModelScope.launch {
            getDogsUseCase().collect {
                it.onSuccess { dogs ->
                    _state.update { it.copy(dogs = dogs) }
                }
            }
        }
    }
}