package com.alexmprog.thepets.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CatEntity(
    @PrimaryKey val url: String,
)