package com.alexmprog.thepets.feature.dogs.impl.data.network

import kotlinx.serialization.Serializable

@Serializable
internal data class DogsResponse(
    val message: List<String>,
    val status: String
)