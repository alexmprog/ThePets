package com.alexmprog.thepets.domain.cats.usecase

import com.alexmprog.thepets.domain.cats.model.Cat
import com.alexmprog.thepets.domain.cats.repository.CatsRepository

class DeleteCatUseCase(private val catsRepository: CatsRepository) {

    suspend operator fun invoke(cat: Cat) = catsRepository.deleteCat(cat)
}