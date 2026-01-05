package com.alexmprog.thepets.feature.cats.impl.domain.usecase

import kotlinx.coroutines.flow.Flow
import com.alexmprog.thepets.feature.cats.api.domain.model.Cat
import com.alexmprog.thepets.feature.cats.api.domain.usecase.ObserveCatsUseCase
import com.alexmprog.thepets.feature.cats.impl.domain.repository.CatsRepository

internal class ObserveCatsUseCaseImpl(private val catsRepository: CatsRepository): ObserveCatsUseCase {

    override operator fun invoke(): Flow<List<Cat>> = catsRepository.observeCats()
}