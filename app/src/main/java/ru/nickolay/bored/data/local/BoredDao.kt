package ru.nickolay.bored.data.local

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ru.nickolay.bored.domain.model.Activity

interface BoredDao {
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertBoredActivity(bored: BoredEntity)

        @Query("SELECT * FROM bored WHERE keyId = :keyId")
        suspend fun getBored(keyId: Int): BoredEntity?

        @Query("SELECT * FROM bored WHERE type = :type")
        suspend fun getBoredByCategory(type: String): List<BoredEntity>

        @Update
        suspend fun update(bored: BoredEntity)

        @Transaction
        suspend fun setFavorite(isFavorite: Boolean, keyId: Int) {
            val item = getByKey(keyId) ?: return
            val itemFavorite = item.copy(isFavorite = isFavorite)
            update(itemFavorite)
        }

        @Query("SELECT * FROM bored WHERE keyId = :keyId")
        suspend fun getByKey(keyId: Int): BoredEntity?

        @Query("SELECT * FROM bored WHERE isFavorite = true")
        fun getFavoriteActivities(): Flow<List<BoredEntity>>
}