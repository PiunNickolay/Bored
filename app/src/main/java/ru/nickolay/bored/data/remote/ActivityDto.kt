package ru.nickolay.bored.data.remote

data class ActivityDto(
    val accessibility: String,
    val activity: String,
    val availability: Double,
    val duration: String,
    val key: String,
    val kidFriendly: Boolean,
    val link: String,
    val participants: Int,
    val price: Double,
    val type: String
)