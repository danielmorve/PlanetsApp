package com.example.planetsapp.domain.use_cases

import com.example.planetsapp.data.PlanetService
import com.example.planetsapp.domain.ApiResult
import com.example.planetsapp.domain.models.Planets
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPlanets(private val planetService: PlanetService) {
    operator fun invoke(): Flow<ApiResult<List<Planets>>> = flow {

        try {
            emit(ApiResult.Loading("Cargando..."))
            val response = planetService.getPlanets()
            emit(ApiResult.Success(response))
        } catch (e: Exception) {
            emit(ApiResult.Error(message = "Ha ocurrido un error", data = emptyList()))


        }
    }
}