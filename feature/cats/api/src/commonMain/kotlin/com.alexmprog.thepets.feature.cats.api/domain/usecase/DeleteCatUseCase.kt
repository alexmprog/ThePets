package com.alexmprog.thepets.feature.cats.api.domain.usecase

import com.alexmprog.thepets.feature.cats.api.domain.model.Cat
import com.alexmprog.thepets.feature.cats.api.domain.repository.CatsRepository

class DeleteCatUseCase(private val catsRepository: CatsRepository) {

    suspend operator fun invoke(cat: Cat) = catsRepository.deleteCat(cat)
}