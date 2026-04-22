package ru.nickolay.bored.domain


import kotlinx.coroutines.flow.Flow
import ru.nickolay.bored.domain.model.Activity

interface BoredRepository {
    suspend fun getRandomActivity(): Activity

    suspend fun setFavorite(activity: Activity)

    fun getFavorites(): Flow<List<Activity>>

    suspend fun getActivityByCategory(type: ActivityType): List<Activity>
}