package com.alexmprog.thepets.feature.cats.impl.domain.usecase

import com.alexmprog.common.utils.resource.Error
import com.alexmprog.common.utils.resource.Resource
import com.alexmprog.thepets.feature.cats.api.domain.model.Cat
import com.alexmprog.thepets.feature.cats.api.domain.usecase.GetCatsUseCase
import com.alexmprog.thepets.feature.cats.impl.domain.repository.CatsRepository

internal class GetCatsUseCaseImpl(private val catsRepository: CatsRepository): GetCatsUseCase {

    override suspend operator fun invoke(limit: Int): Resource<List<Cat>, Error> =
        catsRepository.getCats(limit)
}