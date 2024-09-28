package com.alexmprog.thepets.domain.dogs.repository

import com.alexmprog.common.utils.resource.Error
import com.alexmprog.common.utils.resource.Resource
import com.alexmprog.thepets.domain.dogs.model.Dog
import kotlinx.coroutines.flow.Flow

interface DogsRepository {

    suspend fun getDogs(limit: Int): Resource<List<Dog>, Error>

    suspend fun saveDog(dog: Dog)

    suspend fun deleteDog(dog: Dog)

    fun observerDogs(): Flow<List<Dog>>
}