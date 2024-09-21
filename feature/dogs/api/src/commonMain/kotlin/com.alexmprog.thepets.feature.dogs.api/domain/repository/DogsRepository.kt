package com.alexmprog.thepets.feature.dogs.api.domain.repository

import com.alexmprog.thepets.core.utils.Error
import com.alexmprog.thepets.core.utils.Resource
import com.alexmprog.thepets.feature.dogs.api.domain.model.Dog
import kotlinx.coroutines.flow.Flow

interface DogsRepository {
    fun getDogs(): Flow<Resource<List<Dog>, Error>>
}