package com.alexmprog.thepets.data.cats.network

import kotlinx.serialization.Serializable

@Serializable
internal data class CatDto(
    val id: String,
    val url: String
)