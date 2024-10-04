package com.alexmprog.thepets.feature.cats.impl.presentation

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.alexmprog.common.utils.resource.onError
import com.alexmprog.common.utils.resource.onSuccess
import com.alexmprog.thepets.domain.cats.model.Cat
import com.alexmprog.thepets.domain.cats.usecase.GetCatsUseCase
import com.alexmprog.thepets.domain.cats.usecase.SaveCatUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.StateFlow
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container

internal data class CatsScreenState(
    val isLoading: Boolean = false,
    val showError: Boolean = false,
    val cats: List<Cat> = emptyList()
)

internal class CatsScreenModel(
    private val getCatsUseCase: GetCatsUseCase,
    private val saveCatUseCase: SaveCatUseCase
) : ContainerHost<CatsScreenState, Unit>, ScreenModel {

    private var refreshJob: Job? = null

    override val container =
        screenModelScope.container<CatsScreenState, Unit>(CatsScreenState())

    val state: StateFlow<CatsScreenState> = container.refCountStateFlow

    init {
        refresh()
    }

    fun refresh() {
        refreshJob?.cancel()
        refreshJob = intent {
            reduce { state.copy(isLoading = true) }
            getCatsUseCase(9)
                .onSuccess { cats ->
                    reduce { state.copy(isLoading = false, cats = cats) }
                }.onError {
                    reduce { CatsScreenState(showError = true) }
                }
        }
    }

    fun save(cat: Cat) {
        intent {
            saveCatUseCase(cat)
            reduce {
                val items = state.cats.toMutableList()
                items.remove(cat)
                state.copy(cats = items)
            }
        }
    }
}