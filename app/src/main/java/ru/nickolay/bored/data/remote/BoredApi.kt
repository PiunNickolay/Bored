package ru.nickolay.bored.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BoredApi {
    @GET("https://bored-api.appbrewery.com/random")
    suspend fun getRandomActivity(): ActivityDto

    //Переделать, выделить BASE_URL
    @GET("filter")
    suspend fun getFilteredActivity(
        @Query("type") type: String
    ): List<ActivityDto>
}