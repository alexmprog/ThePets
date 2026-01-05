package com.alexmprog.thepets.feature.dogs.impl.domain.usecase

import com.alexmprog.thepets.feature.dogs.api.domain.model.Dog
import com.alexmprog.thepets.feature.dogs.api.domain.usecase.SaveDogUseCase
import com.alexmprog.thepets.feature.dogs.impl.domain.repository.DogsRepository

internal class SaveDogUseCaseImpl(private val dogsRepository: DogsRepository) : SaveDogUseCase {

    override suspend operator fun invoke(dog: Dog) = dogsRepository.saveDog(dog)
}
