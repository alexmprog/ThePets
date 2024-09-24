package com.alexmprog.thepets.domain.dogs.usecase

import com.alexmprog.thepets.domain.dogs.model.Dog
import com.alexmprog.thepets.domain.dogs.repository.DogsRepository

class DeleteDogUseCase(private val dogsRepository: DogsRepository) {

    suspend operator fun invoke(dog: Dog) = dogsRepository.deleteDog(dog)
}