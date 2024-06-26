package com.example.planetsapp.presentation.screens

import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.planetsapp.R
import com.example.planetsapp.domain.models.Planets
import com.example.planetsapp.presentation.viewmodels.PlanetDetailViewModel

@Composable
fun DetailScreen(planetId:String,
                 planetDetailViewModel: PlanetDetailViewModel = hiltViewModel()) {
    val state = planetDetailViewModel.planetState.value

    if (state.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            AsyncImage(
                model = state.planet.image,
                contentDescription = null,
                placeholder = painterResource(id = R.drawable.ic_launcher_background),
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(
                state.planet.name,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(10.dp),
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif
                )
            )

            Text(
                state.planet.description,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(10.dp),
                style = TextStyle(
                    color = Color.DarkGray,
                    fontSize = 16.sp,
                    letterSpacing = 0.15.sp
                )
            )

            Text(
                text = "Caracteristicas",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(10.dp),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif
                )
            )
            Row {
                Column(
                    modifier = Modifier
                        .padding(top = 10.dp, start = 10.dp, end = 10.dp)
                        .weight(0.5f)
                ) {
                    Text(text = "Diametro: ${state.planet.diameter}")
                    Text(text = "Distancia ${state.planet.distance}")
                    Text(text = "Gravedad: ${state.planet.gravity}")
                    Text(text = "Masa: ${state.planet.mass}")

                }
                Column(
                    modifier = Modifier
                        .padding(top = 10.dp, end = 10.dp)
                        .weight(0.5f)
                ) {
                    Text(text = "Lunas: ${state.planet.moons}")
                    Text(text = "Rotacion en: ${state.planet.rotation}")
                    Text(text = "Traslacion en: ${state.planet.traslation}")
                    Text(text = "Tipo: ${state.planet.type}")
                }
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