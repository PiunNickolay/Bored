package ru.nickolay.bored.domain.usecases

import ru.nickolay.bored.domain.ActivityType
import ru.nickolay.bored.domain.BoredRepository
import ru.nickolay.bored.domain.model.Activity

class GetActivityByCategoryUseCase(
    private val repo: BoredRepository
) {
    suspend operator fun invoke(type: ActivityType): List<Activity> = repo.getActivityByCategory(type)
}