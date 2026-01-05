package com.alexmprog.thepets.feature.dogs.impl.domain.usecase

import com.alexmprog.thepets.feature.dogs.api.domain.model.Dog
import com.alexmprog.thepets.feature.dogs.api.domain.usecase.ObserveDogsUseCase
import com.alexmprog.thepets.feature.dogs.impl.domain.repository.DogsRepository
import kotlinx.coroutines.flow.Flow

internal class ObserveDogsUseCaseImpl(private val dogsRepository: DogsRepository) : ObserveDogsUseCase {

    override operator fun invoke(): Flow<List<Dog>> = dogsRepository.observeDogs()
}
