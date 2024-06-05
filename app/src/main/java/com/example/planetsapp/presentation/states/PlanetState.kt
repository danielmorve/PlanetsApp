package com.example.planetsapp.presentation.states

import com.example.planetsapp.domain.models.Planets

data class PlanetState(
    val isLoading: Boolean = false,
    val planet: Planets = Planets(
        _id = "",
        description = "",
        diameter = "",
        distance = "",
        gravity = "",
        image = "",
        mass = "",
        moons = "",
        name = "",
        rotation = "",
        traslation = "",
        type = "",
        __v = 0,
    ),
    val errorMessage: String = ""
) {
}