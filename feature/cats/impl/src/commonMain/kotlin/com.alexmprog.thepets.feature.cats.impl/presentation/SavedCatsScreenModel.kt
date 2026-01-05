package com.alexmprog.thepets.feature.cats.impl.presentation

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.alexmprog.thepets.feature.cats.api.domain.model.Cat
import com.alexmprog.thepets.feature.cats.api.domain.usecase.DeleteCatUseCase
import com.alexmprog.thepets.feature.cats.api.domain.usecase.ObserveCatsUseCase
import kotlinx.coroutines.flow.StateFlow
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container

internal data class SavedCatsScreenState(
    val isLoading: Boolean = false,
    val cats: List<Cat> = emptyList()
)

internal class SavedCatsScreenModel(
    observeCatsUseCase: ObserveCatsUseCase,
    private val deleteCatUseCase: DeleteCatUseCase
) : ContainerHost<SavedCatsScreenState, Unit>, ScreenModel {

    override val container =
        screenModelScope.container<SavedCatsScreenState, Unit>(SavedCatsScreenState()) {
            repeatOnSubscription {
                observeCatsUseCase().collect {
                    reduce { SavedCatsScreenState(false, it) }
                }
            }
        }

    val state: StateFlow<SavedCatsScreenState> = container.refCountStateFlow

    fun delete(cat: Cat) = intent {
        deleteCatUseCase(cat)
    }

}