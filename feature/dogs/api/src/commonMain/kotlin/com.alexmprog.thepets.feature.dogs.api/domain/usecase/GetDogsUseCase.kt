package com.alexmprog.thepets.feature.dogs.api.domain.usecase

import com.alexmprog.thepets.core.utils.Error
import com.alexmprog.thepets.core.utils.Resource
import com.alexmprog.thepets.feature.dogs.api.domain.model.Dog
import com.alexmprog.thepets.feature.dogs.api.domain.repository.DogsRepository

class GetDogsUseCase(private val dogsRepository: DogsRepository) {
    suspend operator fun invoke(limit: Int): Resource<List<Dog>, Error> =
        dogsRepository.getDogs(limit)
}