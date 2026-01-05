package com.alexmprog.thepets.feature.cats.impl.domain.repository

import com.alexmprog.common.utils.resource.Error
import com.alexmprog.common.utils.resource.Resource
import com.alexmprog.thepets.feature.cats.api.domain.model.Cat
import kotlinx.coroutines.flow.Flow

internal interface CatsRepository {

    suspend fun getCats(limit: Int): Resource<List<Cat>, Error>

    suspend fun saveCat(cat: Cat)

    suspend fun deleteCat(cat: Cat)

    fun observeCats(): Flow<List<Cat>>
}