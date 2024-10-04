package com.alexmprog.thepets.feature.dogs.impl.presentation

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.alexmprog.common.utils.resource.onError
import com.alexmprog.common.utils.resource.onSuccess
import com.alexmprog.thepets.domain.dogs.model.Dog
import com.alexmprog.thepets.domain.dogs.usecase.GetDogsUseCase
import com.alexmprog.thepets.domain.dogs.usecase.SaveDogUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.StateFlow
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container

internal data class DogsScreenState(
    val isLoading: Boolean = false,
    val showError: Boolean = false,
    val dogs: List<Dog> = emptyList()
)

internal class DogsScreenModel(
    private val getDogsUseCase: GetDogsUseCase,
    private val saveDogUseCase: SaveDogUseCase
) : ContainerHost<DogsScreenState, Unit>, ScreenModel {

    private var refreshJob: Job? = null

    override val container =
        screenModelScope.container<DogsScreenState, Unit>(DogsScreenState())
    val state: StateFlow<DogsScreenState> = container.refCountStateFlow

    init {
        refresh()
    }

    fun refresh() {
        refreshJob?.cancel()
        refreshJob = intent {
            reduce { state.copy(isLoading = true) }
            getDogsUseCase(9)
                .onSuccess { dogs ->
                    reduce { state.copy(isLoading = false, dogs = dogs) }
                }.onError {
                    reduce { DogsScreenState(showError = true) }
                }
        }
    }

    fun save(dog: Dog) {
        intent {
            saveDogUseCase(dog)
            reduce {
                val items = state.dogs.toMutableList()
                items.remove(dog)
                state.copy(dogs = items)
            }
        }
    }
}