package com.alexmprog.thepets.data.cats.repository

import com.alexmprog.thepets.core.database.dao.CatsDao
import com.alexmprog.thepets.core.database.model.CatEntity
import com.alexmprog.common.utils.resource.Error
import com.alexmprog.common.utils.resource.Resource
import com.alexmprog.common.utils.resource.map
import com.alexmprog.thepets.data.cats.network.CatDto
import com.alexmprog.thepets.data.cats.network.CatsService
import com.alexmprog.thepets.domain.cats.model.Cat
import com.alexmprog.thepets.domain.cats.repository.CatsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

internal class CatsRepositoryImpl(
    private val catsService: CatsService,
    private val catsDao: CatsDao,
    private val coroutineDispatcher: CoroutineDispatcher
) : CatsRepository {

    override suspend fun getCats(limit: Int): Resource<List<Cat>, Error> =
        withContext(coroutineDispatcher) {
            catsService.getCats(limit).map { it.take(limit).map { it.toModel() } }
        }

    override suspend fun saveCat(cat: Cat) {
        catsDao.insert(cat.toEntity())
    }

    override suspend fun deleteCat(cat: Cat) {
        catsDao.delete(cat.id)
    }

    override fun observeCats(): Flow<List<Cat>> = catsDao.observe().map { it.map { it.toModel() } }
}

internal fun CatDto.toModel(): Cat = Cat(id, url)

internal fun CatEntity.toModel(): Cat = Cat(id, url)

internal fun Cat.toEntity(): CatEntity = CatEntity(id, url)