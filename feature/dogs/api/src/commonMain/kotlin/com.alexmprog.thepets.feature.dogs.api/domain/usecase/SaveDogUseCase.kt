package com.alexmprog.thepets.feature.dogs.api.domain.usecase

import com.alexmprog.thepets.feature.dogs.api.domain.model.Dog
import com.alexmprog.thepets.feature.dogs.api.domain.repository.DogsRepository

class SaveDogUseCase(private val dogsRepository: DogsRepository) {
    suspend operator fun invoke(dog: Dog) = dogsRepository.saveDog(dog)
}