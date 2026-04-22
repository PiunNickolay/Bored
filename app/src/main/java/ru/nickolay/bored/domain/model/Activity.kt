package ru.nickolay.bored.domain.model

data class Activity(
    // Насколько активность лёгкая - строка
    val accessibility: String,
    // Наименование самой активности
    val activity: String,
    // Доступность занятия от 0.0 до 1.0
    val availability: Double,
    // Примерная длительность - строка
    val duration: String,
    // Идентификатор активности
    val keyId: Int,
    // Если активность сопровождается доп.ссылкой
    val link: String,
    // Количество людей, необходимых для выполнения активности
    val participants: Int,
    // Стоимость выполнения от 0.0 до 1.0
    val price: Double,
    // Категория активности
    val type: String,
    val isFavorite: Boolean
)
