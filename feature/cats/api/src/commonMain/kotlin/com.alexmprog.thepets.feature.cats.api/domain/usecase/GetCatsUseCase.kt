package com.alexmprog.thepets.feature.cats.api.domain.usecase

import com.alexmprog.thepets.feature.cats.api.domain.model.Cat
import com.alexmprog.common.utils.resource.Error
import com.alexmprog.common.utils.resource.Resource

fun interface GetCatsUseCase{

    suspend operator fun invoke(limit: Int): Resource<List<Cat>, Error>
}