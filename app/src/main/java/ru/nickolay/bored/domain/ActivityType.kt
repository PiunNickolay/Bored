package ru.nickolay.bored.domain

enum class ActivityType(val apiValue: String) {
    EDUCATION("education"), RECREATIONAL("recreational"), SOCIAL("social"),
    DIY("diy"), CHARITY("charity"), COOKING("cooking"),
    RELAXATION("relaxation"), MUSIC("music"), BUSYWORK("busywork")
}