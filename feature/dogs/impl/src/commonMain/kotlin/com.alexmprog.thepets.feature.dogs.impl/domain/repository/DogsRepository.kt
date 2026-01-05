package com.alexmprog.thepets.feature.dogs.impl.domain.repository

import com.alexmprog.common.utils.resource.Error
import com.alexmprog.common.utils.resource.Resource
import com.alexmprog.thepets.feature.dogs.api.domain.model.Dog
import kotlinx.coroutines.flow.Flow

internal interface DogsRepository {

    suspend fun getDogs(limit: Int): Resource<List<Dog>, Error>

    suspend fun saveDog(dog: Dog)

    suspend fun deleteDog(dog: Dog)

    fun observeDogs(): Flow<List<Dog>>
}
