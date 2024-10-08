package com.alexmprog.thepets.domain.dogs.usecase

import com.alexmprog.common.utils.resource.Error
import com.alexmprog.common.utils.resource.Resource
import com.alexmprog.thepets.domain.dogs.model.Dog
import com.alexmprog.thepets.domain.dogs.repository.DogsRepository

class GetDogsUseCase(private val dogsRepository: DogsRepository) {

    suspend operator fun invoke(limit: Int): Resource<List<Dog>, Error> =
        dogsRepository.getDogs(limit)
}