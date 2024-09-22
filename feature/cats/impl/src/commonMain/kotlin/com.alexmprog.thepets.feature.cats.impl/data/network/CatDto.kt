package com.alexmprog.thepets.feature.cats.impl.data.network

import kotlinx.serialization.Serializable

@Serializable
internal data class CatDto(
    val id: String,
    val url: String
)