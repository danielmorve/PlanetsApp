package com.example.planetsapp.domain.use_cases

import com.example.planetsapp.data.PlanetService
import com.example.planetsapp.domain.ApiResult
import com.example.planetsapp.domain.models.Planets
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPlanetsByID(
    private val planetService: PlanetService
) {
    operator fun invoke(id: String): Flow<ApiResult<Planets>> = flow {

        try {
            emit(ApiResult.Loading("Cargando..."))
            val response = planetService.getPlanetById(id)
            emit(ApiResult.Success(data = response))
        } catch (e: Exception) {
            emit(ApiResult.Error(message = "Ha ocurrido un error", data=null))
        }
    }
}