package com.alexmprog.thepets.feature.dogs.api.domain.repository

import com.alexmprog.thepets.core.utils.Error
import com.alexmprog.thepets.core.utils.Resource
import com.alexmprog.thepets.feature.dogs.api.domain.model.Dog
import kotlinx.coroutines.flow.Flow

interface DogsRepository {

    suspend fun getDogs(limit: Int): Resource<List<Dog>, Error>

    suspend fun saveDog(dog: Dog)

    suspend fun deleteDog(dog: Dog)

    fun observerDogs(): Flow<List<Dog>>
}