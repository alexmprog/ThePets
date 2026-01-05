package com.alexmprog.thepets.feature.dogs.impl.presentation

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.alexmprog.thepets.domain.dogs.model.Dog
import com.alexmprog.thepets.domain.dogs.usecase.DeleteDogUseCase
import com.alexmprog.thepets.domain.dogs.usecase.ObserveDogsUseCase
import kotlinx.coroutines.flow.StateFlow
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container

internal data class SavedDogsScreenState(
    val isLoading: Boolean = false,
    val dogs: List<Dog> = emptyList()
)

internal class SavedDogsScreenModel(
    private val observeDogsUseCase: ObserveDogsUseCase,
    private val deleteDogUseCase: DeleteDogUseCase
) : ContainerHost<SavedDogsScreenState, Unit>, ScreenModel {

    override val container =
        screenModelScope.container<SavedDogsScreenState, Unit>(SavedDogsScreenState()) {
            repeatOnSubscription {
                observeDogsUseCase().collect {
                    reduce { SavedDogsScreenState(false, it) }
                }
            }
        }

    val state: StateFlow<SavedDogsScreenState> = container.refCountStateFlow

    fun delete(dog: Dog) = intent {
        deleteDogUseCase(dog)
    }
}