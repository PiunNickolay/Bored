package ru.nickolay.bored.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [BoredEntity::class],
    version = 1
)
abstract class BoredDatabase: RoomDatabase() {
    abstract fun boredDao(): BoredDao
}