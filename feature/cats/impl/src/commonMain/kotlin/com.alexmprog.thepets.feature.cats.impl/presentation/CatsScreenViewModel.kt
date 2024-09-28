package com.alexmprog.thepets.feature.cats.impl.presentation

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.alexmprog.common.utils.onError
import com.alexmprog.common.utils.onSuccess
import com.alexmprog.thepets.domain.cats.model.Cat
import com.alexmprog.thepets.domain.cats.usecase.GetCatsUseCase
import com.alexmprog.thepets.domain.cats.usecase.SaveCatUseCase
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

    fun refresh() {
        screenModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            getCatsUseCase(9)
                .onSuccess { cats ->
                    _state.update { CatsScreenState(cats = cats)}
                }.onError {
                    _state.update { CatsScreenState() }
                }
        }
    }

    fun save(cat: Cat) {
        screenModelScope.launch {
            saveCatUseCase(cat)
            _state.update {
                val items = it.cats.toMutableList()
                items.remove(cat)
                it.copy(cats = items)
            }
        }
    }
}