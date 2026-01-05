package com.alexmprog.thepets.feature.cats.api.domain.usecase

import com.alexmprog.thepets.feature.cats.api.domain.model.Cat

fun interface SaveCatUseCase {
    suspend operator fun invoke(cat: Cat)
}