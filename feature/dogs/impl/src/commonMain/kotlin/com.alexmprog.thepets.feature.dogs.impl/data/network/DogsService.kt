package com.alexmprog.thepets.feature.dogs.impl.data.network

import com.alexmprog.thepets.core.utils.Error
import com.alexmprog.thepets.core.utils.Resource
import com.alexprog.thepets.core.network.fetchUrl
import io.ktor.client.HttpClient

internal interface DogsService {
    suspend fun getDogs(limit: Int): Resource<DogsResponse, Error>
}

internal class DogsServiceImpl(private val httpClient: HttpClient) : DogsService {

    override suspend fun getDogs(limit: Int): Resource<DogsResponse, Error> =
        httpClient.fetchUrl<DogsResponse>("https://dog.ceo/api/breeds/image/random/${limit}")
}
