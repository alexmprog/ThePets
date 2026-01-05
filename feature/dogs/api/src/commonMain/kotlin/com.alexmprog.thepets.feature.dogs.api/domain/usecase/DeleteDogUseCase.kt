package com.alexmprog.thepets.feature.dogs.api.domain.usecase

import com.alexmprog.thepets.feature.dogs.api.domain.model.Dog

fun interface DeleteDogUseCase {
    suspend operator fun invoke(dog: Dog)
}
