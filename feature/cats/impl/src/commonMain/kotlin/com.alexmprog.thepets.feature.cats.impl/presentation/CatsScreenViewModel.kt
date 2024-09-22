package com.alexmprog.thepets.feature.cats.impl.presentation

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.alexmprog.thepets.core.utils.onError
import com.alexmprog.thepets.core.utils.onSuccess
import com.alexmprog.thepets.feature.cats.api.domain.model.Cat
import com.alexmprog.thepets.feature.cats.api.domain.usecase.GetCatsUseCase
import com.alexmprog.thepets.feature.cats.api.domain.usecase.SaveCatUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal data class CatsScreenState(
    val isLoading: Boolean = false,
    val cats: List<Cat> = emptyList()
)

internal class CatsScreenViewModel(
    private val getCatsUseCase: GetCatsUseCase,
    private val saveCatUseCase: SaveCatUseCase
) : ScreenModel {

    private val _state = MutableStateFlow(CatsScreenState())
    val state: StateFlow<CatsScreenState> = _state.asStateFlow()

    init {
        refresh()
    }

    fun refresh() {
        screenModelScope.launch {
            getCatsUseCase(9)
                .onSuccess { cats ->
                    _state.update { it.copy(cats = cats) }
                }.onError {

                }
        }
    }

    fun save(cat: Cat) {
        screenModelScope.launch {
            saveCatUseCase(cat)
        }
    }
}