package com.alexmprog.thepets.feature.cats.api.domain.usecase

import com.alexmprog.thepets.feature.cats.api.domain.model.Cat
import kotlinx.coroutines.flow.Flow

fun interface ObserveCatsUseCase {
    operator fun invoke(): Flow<List<Cat>>
}