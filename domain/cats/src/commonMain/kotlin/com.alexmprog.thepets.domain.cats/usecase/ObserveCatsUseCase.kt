package com.alexmprog.thepets.domain.cats.usecase

import com.alexmprog.thepets.domain.cats.model.Cat
import com.alexmprog.thepets.domain.cats.repository.CatsRepository
import kotlinx.coroutines.flow.Flow

class ObserveCatsUseCase(private val catsRepository: CatsRepository) {

    operator fun invoke(): Flow<List<Cat>> = catsRepository.observeCats()
}