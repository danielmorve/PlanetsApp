package com.example.planetsapp.data

import com.example.planetsapp.domain.models.Planets
import retrofit2.http.GET
import retrofit2.http.Path

interface PlanetService {
    @GET("planets")
    suspend fun getPlanets(): List<Planets>

    @GET("planets/{id}")
    suspend fun getPlanetById(@Path("id") id: String): Planets
}