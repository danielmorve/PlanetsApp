package com.example.planetsapp.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.planetsapp.domain.ApiResult
import com.example.planetsapp.domain.use_cases.GetPlanetsByID
import com.example.planetsapp.presentation.states.PlanetState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PlanetDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getPlanetUseCase: GetPlanetsByID
) : ViewModel() {
    private val planetId = savedStateHandle.get<String>("planetId") ?: ""
    private var planetJob: Job? = null
    private var _planetState = mutableStateOf(PlanetState())
    val planetState = _planetState

    init {
        getPlanet()
    }

    private fun getPlanet() {
        planetJob?.cancel()
        planetJob = getPlanetUseCase(planetId).onEach { result->
            when(result){
                is ApiResult.Loading -> {
                    _planetState.value = PlanetState(isLoading = true)
                }
                is ApiResult.Error -> {
                    _planetState.value = PlanetState(errorMessage = result.message, isLoading = false)
                }
                is ApiResult.Success -> {
                    _planetState.value = result.data?.let { PlanetState(planet = it, isLoading = false) }!!
                }

            }
        }.launchIn(viewModelScope)
    }
}