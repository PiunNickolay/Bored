package ru.nickolay.bored.presentation.feature

import ru.nickolay.bored.domain.model.Activity

fun formatParticipants(count: Int): String = if (count == 1) "1 person" else "$count people"


fun priceOrFree(count: Double): String = if (count>0.0) "Cost" else "Free"

fun availabilityForString(score: Double): String {
    return if (score in 0.0..4.0) {
        "Low"
    } else if(score in 4.1..8.0) {
        "Medium"
    } else {
        "High"
    }
}
