package com.example.planetsapp.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.planetsapp.domain.ApiResult
import com.example.planetsapp.domain.use_cases.GetPlanets
import com.example.planetsapp.presentation.states.PlanetsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PlanetsViewModel @Inject constructor(
    private val getPlanetsUSeCase: GetPlanets

) : ViewModel(){
    private var planetsJob : Job? = null
    private var _planetsState = mutableStateOf(PlanetsState())
    val planetsState = _planetsState

    init {
        getPlanets()

    }

    private fun getPlanets() {
        planetsJob?.cancel()
        planetsJob = getPlanetsUSeCase().onEach { result ->
            when (result) {
                is ApiResult.Loading -> {
                    // Show loading
                    _planetsState.value = PlanetsState(isLoading = true)
                }

                is ApiResult.Error -> {
                    // Show error
                    _planetsState.value = PlanetsState(errorMessage = result.message)
                }

                is ApiResult.Success -> {
                    // Show data
                    _planetsState.value = PlanetsState(planets = result.data!!)
                }
            }
        }.launchIn(viewModelScope)
    }
}