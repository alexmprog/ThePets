package com.alexmprog.thepets.feature.cats.impl.data.network

import com.alexmprog.thepets.core.utils.Error
import com.alexmprog.thepets.core.utils.Resource
import com.alexprog.thepets.core.network.fetchUrl
import io.ktor.client.HttpClient

internal interface CatsService {
    suspend fun getCats(limit: Int): Resource<List<CatDto>, Error>
}

internal class CatsServiceImpl(private val httpClient: HttpClient) : CatsService {

    override suspend fun getCats(limit: Int): Resource<List<CatDto>, Error> =
        httpClient.fetchUrl<List<CatDto>>("https://api.thecatapi.com/v1/images/search?limit=${limit}")
}
