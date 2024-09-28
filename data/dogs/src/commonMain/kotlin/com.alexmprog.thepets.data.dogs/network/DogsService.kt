package com.alexmprog.thepets.data.dogs.network

import com.alexmprog.common.utils.Error
import com.alexmprog.common.utils.Resource
import com.alexmprog.thepets.core.network.fetchUrl
import io.ktor.client.HttpClient

internal interface DogsService {
    suspend fun getDogs(limit: Int): Resource<DogsResponse, Error>
}

internal class DogsServiceImpl(private val httpClient: HttpClient) : DogsService {

    override suspend fun getDogs(limit: Int): Resource<DogsResponse, Error> =
        httpClient.fetchUrl<DogsResponse>("https://dog.ceo/api/breeds/image/random/${limit}")
}
