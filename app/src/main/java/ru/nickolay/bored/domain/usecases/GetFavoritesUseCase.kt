package ru.nickolay.bored.domain.usecases

import kotlinx.coroutines.flow.Flow
import ru.nickolay.bored.domain.BoredRepository
import ru.nickolay.bored.domain.model.Activity

class GetFavoritesUseCase(
    private val repo: BoredRepository
) {
    operator fun invoke(): Flow<List<Activity>> = repo.getFavorites()
}