package com.alexmprog.thepets.data.dogs.repository

import com.alexmprog.thepets.core.database.dao.DogsDao
import com.alexmprog.thepets.core.database.model.DogEntity
import com.alexmprog.common.utils.resource.Error
import com.alexmprog.common.utils.resource.Resource
import com.alexmprog.common.utils.resource.map
import com.alexmprog.thepets.data.dogs.network.DogsResponse
import com.alexmprog.thepets.data.dogs.network.DogsService
import com.alexmprog.thepets.domain.dogs.model.Dog
import com.alexmprog.thepets.domain.dogs.repository.DogsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

internal class DogsRepositoryImpl(
    private val dogsService: DogsService,
    private val dogsDao: DogsDao,
    private val coroutineDispatcher: CoroutineDispatcher
) : DogsRepository {

    override suspend fun getDogs(limit: Int): Resource<List<Dog>, Error> =
        withContext(coroutineDispatcher) {
            dogsService.getDogs(limit).map { it.toModel() }
        }

    override suspend fun saveDog(dog: Dog) {
        dogsDao.insert(dog.toEntity())
    }

    override suspend fun deleteDog(dog: Dog) {
        dogsDao.delete(dog.id)
    }

    override fun observerDogs(): Flow<List<Dog>> = dogsDao.observe().map { it.map { it.toModel() } }
}

internal fun DogsResponse.toModel(): List<Dog> = message.map { Dog(it, it) }

internal fun DogEntity.toModel(): Dog = Dog(id, url)

internal fun Dog.toEntity(): DogEntity = DogEntity(id, url)