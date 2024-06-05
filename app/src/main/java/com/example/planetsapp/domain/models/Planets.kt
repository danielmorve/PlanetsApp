package com.example.planetsapp.domain.models

data class Planets(
    val _id: String,
    val description: String,
    val diameter: String,
    val distance: String,
    val gravity: String,
    val image: String,
    val mass: String,
    val moons: String,
    val name: String,
    val rotation: String,
    val traslation: String,
    val type: String,
    val __v: Int
    ){

    companion object{
        val planetsList = List(10){
            Planets(
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
            )
        }
    }
}