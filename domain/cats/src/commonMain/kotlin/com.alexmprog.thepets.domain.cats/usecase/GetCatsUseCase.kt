package com.alexmprog.thepets.domain.cats.usecase

import com.alexmprog.common.utils.resource.Error
import com.alexmprog.common.utils.resource.Resource
import com.alexmprog.thepets.domain.cats.model.Cat
import com.alexmprog.thepets.domain.cats.repository.CatsRepository

class GetCatsUseCase(private val catsRepository: CatsRepository) {

    suspend operator fun invoke(limit: Int): Resource<List<Cat>, Error> =
        catsRepository.getCats(limit)
}