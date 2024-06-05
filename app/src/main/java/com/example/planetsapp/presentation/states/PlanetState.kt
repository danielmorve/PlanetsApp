package com.example.planetsapp.presentation.states

import com.example.planetsapp.domain.models.Planets

class PlanetState(
    val isLoading: Boolean = false,
    val planet: Planets = Planets(
        _id = "65f4e6a2c2aca276416a4ce3",
        description = "Planeta más cercano al Sol y el más pequeño del sistema solar.",
        diameter = "4,880",
        distance = "57,910,000",
        gravity = "3.7",
        image = "https://upload.wikimedia.org/wikipedia/commons/thumb/3/30/Mercury_in_color_-_Prockter07_centered.jpg/1200px-Mercury_in_color_-_Prockter07_centered.jpg",
        mass = "3.285 × 10^23",
        moons = "0",
        name = "Mercurio",
        rotation = "1,408",
        traslation = "88",
        type = "Planeta rocoso",
        __v = 0,
    ),
    val errorMessage: String = ""
) {
}