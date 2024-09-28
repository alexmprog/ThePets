package com.alexmprog.thepets.domain.cats.repository

import com.alexmprog.common.utils.resource.Error
import com.alexmprog.common.utils.resource.Resource
import com.alexmprog.thepets.domain.cats.model.Cat
import kotlinx.coroutines.flow.Flow

interface CatsRepository {

    suspend fun getCats(limit: Int): Resource<List<Cat>, Error>

    suspend fun saveCat(cat: Cat)

    suspend fun deleteCat(cat: Cat)

    fun observeCats(): Flow<List<Cat>>
}