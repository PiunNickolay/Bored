package ru.nickolay.bored.data.mapper

import ru.nickolay.bored.data.local.BoredEntity
import ru.nickolay.bored.data.remote.ActivityDto
import ru.nickolay.bored.domain.ActivityType
import ru.nickolay.bored.domain.model.Activity

fun ActivityDto.toDomain() : Activity = Activity(
    accessibility = accessibility,
    activity = activity,
    availability = availability,
    duration = duration,
    keyId = key.toInt(),
    link = link,
    participants = participants,
    price = price,
    type = type,
    isFavorite = false
)

fun BoredEntity.toDomain(): Activity = Activity(
    accessibility = accessibility,
    activity = activity,
    availability = availability,
    duration = duration,
    keyId = keyId,
    link = link,
    participants = participants,
    price = price,
    type = type,
    isFavorite = isFavorite
)

fun Activity.toEntity(): BoredEntity = BoredEntity(
    accessibility = accessibility,
    activity = activity,
    availability = availability,
    duration = duration,
    keyId = keyId,
    link = link,
    participants = participants,
    price = price,
    type = type,
    isFavorite
)

