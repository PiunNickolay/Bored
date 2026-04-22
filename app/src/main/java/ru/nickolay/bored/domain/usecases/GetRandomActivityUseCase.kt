package ru.nickolay.bored.domain.usecases

import ru.nickolay.bored.domain.BoredRepository
import ru.nickolay.bored.domain.model.Activity

class GetRandomActivityUseCase(
    private val repo: BoredRepository) {
    suspend operator fun invoke(): Activity = repo.getRandomActivity()
}