package ru.nickolay.bored.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.nickolay.bored.data.local.BoredDao
import ru.nickolay.bored.data.mapper.toDomain
import ru.nickolay.bored.data.mapper.toEntity
import ru.nickolay.bored.data.remote.BoredApi
import ru.nickolay.bored.domain.ActivityType
import ru.nickolay.bored.domain.BoredRepository
import ru.nickolay.bored.domain.model.Activity
import java.nio.file.attribute.AclEntryType

class BoredRepositoryImpl(
    private val api: BoredApi,
    private val dao: BoredDao
): BoredRepository {
    override suspend fun getRandomActivity(): Activity {
        return api.getRandomActivity().toDomain()
    }

    override suspend fun setFavorite(activity: Activity) {
        val entity = activity.toEntity()
        val current = dao.getByKey(entity.keyId)
        val updated = if (current != null) {
            current.copy(isFavorite = !current.isFavorite)
        } else {
            entity.copy(isFavorite = true)
        }
        dao.update(updated)

        //или просто
//        dao.setFavorite(isFavorite = activity.isFavorite,  keyId = activity.keyId)
    }

    override fun getFavorites(): Flow<List<Activity>> {
        return dao.getFavoriteActivities().map { list -> list.map { it.toDomain() }  }
    }

    override suspend fun getActivityByCategory(type: ActivityType): List<Activity> {
        return api.getFilteredActivity(type.apiValue).map { it.toDomain() }
    }

}