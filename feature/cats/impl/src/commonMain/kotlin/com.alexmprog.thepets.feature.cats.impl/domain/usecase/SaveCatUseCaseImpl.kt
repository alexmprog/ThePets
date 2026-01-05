package com.alexmprog.thepets.feature.cats.impl.domain.usecase

import com.alexmprog.thepets.feature.cats.api.domain.model.Cat
import com.alexmprog.thepets.feature.cats.api.domain.usecase.SaveCatUseCase
import com.alexmprog.thepets.feature.cats.impl.domain.repository.CatsRepository

internal class SaveCatUseCaseImpl(private val catsRepository: CatsRepository): SaveCatUseCase {

    override suspend operator fun invoke(cat: Cat) = catsRepository.saveCat(cat)
}