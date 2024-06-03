package com.example.planetsapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.planetsapp.R
import com.example.planetsapp.models.Planets

@Composable
fun DetailScreen(planetId:String){
    val planet  = Planets.planetsList.first{ it._id == planetId}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        AsyncImage(model = planet.image,
            contentDescription = null,
            placeholder = painterResource(id = R.drawable.ic_launcher_background),
            modifier = Modifier
                .fillMaxWidth()
                .height(370.dp))
        Text(planet.name,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 10.dp),
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
            )
        )

        Text(planet.description,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(top = 10.dp),
            style = TextStyle(
                color = Color.DarkGray,
                fontSize = 16.sp,
                letterSpacing = 0.15.sp
            )
        )

        Text(text = "Caracteristicas",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 10.dp),
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
            ))
        Row {
            Column(
                modifier = Modifier
                    .padding(top = 10.dp, end = 10.dp)
                    .weight(0.5f)
            ) {
                Text(text = "Diametro: ${planet.diameter} km")
                Text(text = "Distancia ${planet.distance} km")
                Text(text = "Gravedad: ${planet.gravity} m/s²")
                Text(text = "Masa: ${planet.mass} kg")

            }
            Column(
                modifier = Modifier
                    .padding(top = 10.dp, end = 10.dp)
                    .weight(0.5f)
            ) {
                Text(text = "Lunas: ${planet.moons}")
                Text(text = "Rotacion en: ${planet.rotation} horas")
                Text(text = "Traslacion en: ${planet.traslation} dias")
                Text(text = "Tipo: ${planet.type}")
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)

@Composable
fun PreviewDetailScreen(){
    DetailScreen("65f4e6a2c2aca276416a4ce3")
}