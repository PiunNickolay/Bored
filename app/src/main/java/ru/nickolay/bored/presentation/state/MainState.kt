package ru.nickolay.bored.presentation.state

import ru.nickolay.bored.domain.ActivityType
import ru.nickolay.bored.domain.model.Activity

data class MainState(
    val activity: Activity?,
    val isLoading: Boolean = false,
    val error: String? = null,
    val selectedType: ActivityType? = null
)
