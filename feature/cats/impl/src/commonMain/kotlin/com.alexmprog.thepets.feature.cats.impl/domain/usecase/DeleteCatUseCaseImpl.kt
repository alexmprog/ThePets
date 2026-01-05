package com.alexmprog.thepets.feature.cats.impl.domain.usecase

import com.alexmprog.thepets.feature.cats.api.domain.model.Cat
import com.alexmprog.thepets.feature.cats.api.domain.usecase.DeleteCatUseCase
import com.alexmprog.thepets.feature.cats.impl.domain.repository.CatsRepository

internal class DeleteCatUseCaseImpl(private val catsRepository: CatsRepository) : DeleteCatUseCase {

    override suspend operator fun invoke(cat: Cat) = catsRepository.deleteCat(cat)
}