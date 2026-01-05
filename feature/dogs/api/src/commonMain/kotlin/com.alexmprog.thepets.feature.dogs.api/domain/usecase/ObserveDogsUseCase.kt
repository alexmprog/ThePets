package com.alexmprog.thepets.feature.dogs.api.domain.usecase

import com.alexmprog.thepets.feature.dogs.api.domain.model.Dog
import kotlinx.coroutines.flow.Flow

fun interface ObserveDogsUseCase {
    operator fun invoke(): Flow<List<Dog>>
}
