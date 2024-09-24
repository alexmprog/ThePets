package com.alexmprog.thepets.domain.dogs.usecase

import com.alexmprog.thepets.domain.dogs.model.Dog
import com.alexmprog.thepets.domain.dogs.repository.DogsRepository
import kotlinx.coroutines.flow.Flow

class ObserveDogsUseCase(private val dogsRepository: DogsRepository) {

    operator fun invoke(): Flow<List<Dog>> = dogsRepository.observerDogs()
}