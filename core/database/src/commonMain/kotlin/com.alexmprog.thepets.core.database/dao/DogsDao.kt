package com.alexmprog.thepets.core.database.dao

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import comalexmprogthepetscoredatabase.Dog
import comalexmprogthepetscoredatabase.DogQueries
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

interface DogsDao {
    suspend fun getDogs(): Flow<List<Dog>>
    suspend fun saveDog(dog: Dog)
    suspend fun deleteDog(dog: Dog)
}

internal class DogsDaoImpl(
    private val queries: DogQueries,
    private val dispatcher: CoroutineDispatcher
) : DogsDao {

    override suspend fun getDogs(): Flow<List<Dog>> =
        queries.selectAll().asFlow().mapToList(dispatcher)

    override suspend fun saveDog(dog: Dog) = withContext(dispatcher) {
        queries.insert(dog.url, dog.breed)
    }

    override suspend fun deleteDog(dog: Dog) = withContext(dispatcher) {
        queries.deleteByUrl(dog.url)
    }

}