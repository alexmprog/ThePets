package com.alexmprog.thepets.feature.dogs.impl.data.network

import com.alexmprog.common.utils.resource.Error
import com.alexmprog.common.utils.resource.Resource
import com.alexmprog.thepets.core.network.fetchUrl
import io.ktor.client.HttpClient

internal interface DogsService {
    suspend fun getDogs(limit: Int): Resource<DogsResponse, Error>
}

internal class DogsServiceImpl(private val httpClient: HttpClient) : DogsService {

    override suspend fun getDogs(limit: Int): Resource<DogsResponse, Error> =
        httpClient.fetchUrl("https://dog.ceo/api/breeds/image/random/$limit")
}
