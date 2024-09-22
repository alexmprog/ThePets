package com.alexmprog.thepets.feature.cats.impl.presentation

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.alexmprog.thepets.feature.cats.api.domain.model.Cat
import com.alexmprog.thepets.feature.cats.api.domain.usecase.DeleteCatUseCase
import com.alexmprog.thepets.feature.cats.api.domain.usecase.ObserveCatsUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

internal data class SavedCatsScreenState(
    val isLoading: Boolean = false,
    val cats: List<Cat> = emptyList()
)

internal class SavedCatsScreenViewModel(
    private val observeCatsUseCase: ObserveCatsUseCase,
    private val deleteCatUseCase: DeleteCatUseCase
) : ScreenModel {

    val state: StateFlow<SavedCatsScreenState> = observeCatsUseCase()
        .map { SavedCatsScreenState(false, it) }
        .stateIn(
            scope = screenModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = SavedCatsScreenState(isLoading = true),
        )

    fun delete(cat: Cat) {
        screenModelScope.launch {
            deleteCatUseCase(cat)
        }
    }

}