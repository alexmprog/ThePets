package com.alexmprog.thepets.feature.dogs.api.domain.usecase

import com.alexmprog.thepets.feature.dogs.api.domain.model.Dog
import com.alexmprog.thepets.feature.dogs.api.domain.repository.DogsRepository
import kotlinx.coroutines.flow.Flow

class ObserveDogsUseCase(private val dogsRepository: DogsRepository) {
    operator fun invoke(): Flow<List<Dog>> = dogsRepository.observerDogs()
}