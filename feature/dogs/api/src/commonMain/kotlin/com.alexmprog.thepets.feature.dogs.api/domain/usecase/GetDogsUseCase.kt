package com.alexmprog.thepets.feature.dogs.api.domain.usecase

import com.alexmprog.common.utils.resource.Error
import com.alexmprog.common.utils.resource.Resource
import com.alexmprog.thepets.feature.dogs.api.domain.model.Dog

fun interface GetDogsUseCase {

    suspend operator fun invoke(limit: Int): Resource<List<Dog>, Error>
}
