package com.alexmprog.thepets.feature.cats.api.domain.usecase

import com.alexmprog.thepets.feature.cats.api.domain.model.Cat
import com.alexmprog.thepets.feature.cats.api.domain.repository.CatsRepository
import kotlinx.coroutines.flow.Flow

class ObserveCatsUseCase(private val catsRepository: CatsRepository) {

    operator fun invoke(): Flow<List<Cat>> = catsRepository.observerCats()
}