package com.alexmprog.thepets.feature.cats.api.domain.usecase

import com.alexmprog.thepets.core.utils.Error
import com.alexmprog.thepets.core.utils.Resource
import com.alexmprog.thepets.feature.cats.api.domain.model.Cat
import com.alexmprog.thepets.feature.cats.api.domain.repository.CatsRepository

class GetCatsUseCase(private val catsRepository: CatsRepository) {

    suspend operator fun invoke(limit: Int): Resource<List<Cat>, Error> =
        catsRepository.getCats(limit)
}