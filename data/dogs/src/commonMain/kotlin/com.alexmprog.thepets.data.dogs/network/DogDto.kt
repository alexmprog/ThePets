package com.alexmprog.thepets.data.dogs.network

import kotlinx.serialization.Serializable

@Serializable
internal data class DogsResponse(
    val message: List<String>,
    val status: String
)