package com.alexmprog.thepets.feature.cats.api.domain.usecase

import com.alexmprog.thepets.feature.cats.api.domain.model.Cat
import com.alexmprog.thepets.feature.cats.api.domain.repository.CatsRepository

class SaveCatUseCase(private val catsRepository: CatsRepository) {

    suspend operator fun invoke(cat: Cat) = catsRepository.saveCat(cat)
}