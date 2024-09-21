package com.alexmprog.thepets.feature.dogs.impl.data.repository

import com.alexmprog.thepets.core.database.dao.DogsDao
import com.alexmprog.thepets.core.utils.Error
import com.alexmprog.thepets.core.utils.Resource
import com.alexmprog.thepets.core.utils.map
import com.alexmprog.thepets.feature.dogs.api.domain.model.Dog
import com.alexmprog.thepets.feature.dogs.api.domain.repository.DogsRepository
import com.alexmprog.thepets.feature.dogs.impl.data.network.DogsResponse
import com.alexmprog.thepets.feature.dogs.impl.data.network.DogsService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class DogsRepositoryImpl(
    private val dogsService: DogsService,
    private val dogsDao: DogsDao
) : DogsRepository {

    override fun getDogs(): Flow<Resource<List<Dog>, Error>> = flow {
        emit(dogsService.getDogs(9).map { it.toModel() })
    }
}

internal fun DogsResponse.toModel(): List<Dog> = message.map { Dog(it) }