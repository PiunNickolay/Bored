package ru.nickolay.bored.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bored")
data class BoredEntity(
    val accessibility: String,
    val activity: String,
    val availability: Double,
    val duration: String,
    @PrimaryKey val keyId: Int,
    val link: String,
    val participants: Int,
    val price: Double,
    val type: String,
    val isFavorite: Boolean
)
