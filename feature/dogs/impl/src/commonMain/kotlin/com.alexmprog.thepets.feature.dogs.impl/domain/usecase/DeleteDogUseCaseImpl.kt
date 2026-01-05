package com.alexmprog.thepets.feature.dogs.impl.domain.usecase

import com.alexmprog.thepets.feature.dogs.api.domain.model.Dog
import com.alexmprog.thepets.feature.dogs.api.domain.usecase.DeleteDogUseCase
import com.alexmprog.thepets.feature.dogs.impl.domain.repository.DogsRepository

internal class DeleteDogUseCaseImpl(private val dogsRepository: DogsRepository) : DeleteDogUseCase {

    override suspend operator fun invoke(dog: Dog) = dogsRepository.deleteDog(dog)
}
