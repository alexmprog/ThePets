package com.alexmprog.thepets.feature.dogs.api.domain.usecase

import com.alexmprog.thepets.core.utils.Error
import com.alexmprog.thepets.core.utils.Resource
import com.alexmprog.thepets.feature.dogs.api.domain.model.Dog
import com.alexmprog.thepets.feature.dogs.api.domain.repository.DogsRepository
import kotlinx.coroutines.flow.Flow

class GetDogsUseCase(private val dogsRepository: DogsRepository) {
    operator fun invoke(): Flow<Resource<List<Dog>, Error>> = dogsRepository.getDogs()
}