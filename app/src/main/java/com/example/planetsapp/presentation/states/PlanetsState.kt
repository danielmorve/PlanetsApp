package com.example.planetsapp.presentation.states

import com.example.planetsapp.domain.models.Planets

class PlanetsState(
    val isLoading: Boolean = false,
    val planets: List<Planets> = emptyList(),
    val errorMessage: String = ""
) {
}