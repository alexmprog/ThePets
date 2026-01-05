package com.alexmprog.thepets.feature.dogs.impl.domain.usecase

import com.alexmprog.common.utils.resource.Error
import com.alexmprog.common.utils.resource.Resource
import com.alexmprog.thepets.feature.dogs.api.domain.model.Dog
import com.alexmprog.thepets.feature.dogs.api.domain.usecase.GetDogsUseCase
import com.alexmprog.thepets.feature.dogs.impl.domain.repository.DogsRepository

internal class GetDogsUseCaseImpl(private val dogsRepository: DogsRepository) : GetDogsUseCase {

    override suspend operator fun invoke(limit: Int): Resource<List<Dog>, Error> =
        dogsRepository.getDogs(limit)
}
