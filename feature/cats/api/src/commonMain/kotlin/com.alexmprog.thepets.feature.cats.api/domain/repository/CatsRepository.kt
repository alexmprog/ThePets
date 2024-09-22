package com.alexmprog.thepets.feature.cats.api.domain.repository

import com.alexmprog.thepets.core.utils.Error
import com.alexmprog.thepets.core.utils.Resource
import com.alexmprog.thepets.feature.cats.api.domain.model.Cat
import kotlinx.coroutines.flow.Flow

interface CatsRepository {

    suspend fun getCats(limit: Int): Resource<List<Cat>, Error>

    suspend fun saveCat(cat: Cat)

    suspend fun deleteCat(cat: Cat)

    fun observerCats(): Flow<List<Cat>>
}