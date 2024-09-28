package com.alexmprog.thepets.data.cats.network

import com.alexmprog.common.utils.Error
import com.alexmprog.common.utils.Resource
import com.alexmprog.thepets.core.network.fetchUrl
import io.ktor.client.HttpClient

internal interface CatsService {
    suspend fun getCats(limit: Int): Resource<List<CatDto>, Error>
}

internal class CatsServiceImpl(private val httpClient: HttpClient) : CatsService {

    override suspend fun getCats(limit: Int): Resource<List<CatDto>, Error> =
        httpClient.fetchUrl<List<CatDto>>("https://api.thecatapi.com/v1/images/search?limit=${limit}")
}
