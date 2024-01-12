package com.example.tienda2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

data class Ropa(
    val name: String, val imagen : Int, val precio:Double, val descripcion:String
)
@Composable
fun RopaItem(ropa: Juguetes) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Mostrar la foto utilizando el componente Image
        Image(
            painter = painterResource(id = ropa.imagen),
            contentDescription = null, // Descripción de la imagen
            modifier = Modifier
                .size(150.dp) // Tamaño de la imagen
        )

        // Mostrar el nombre, descripción y precio
        Text(text = ropa.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(text = ropa.descripcion, fontSize = 16.sp)
        Text(text = "Precio: $${ropa.precio}", fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun Ropa (controladorNavegacion: NavHostController){
    Text(text = "ROPA", fontSize = 35.sp, fontWeight = FontWeight.Bold)//Titulo de la pagina

    val categorias = listOf(
        Juguetes("Sudadera Scuffers",R.drawable.sudadera,40.99,"Sudadera marron clarito de la marca scuffers"),
        Juguetes("Camiseta Real Madrid", R.drawable.realmadrid, 99.99, "Camiseta del Real Madrid Temporada 2023/2024"),
        Juguetes("Gorra Palm Angels",R.drawable.gorra,80.95, "Gorra marron de la marca Palm Angels")
    )

    LazyColumn {
        items(categorias) { ropa ->
            RopaItem(ropa = ropa)
            //Separador entre elementos
            Divider(modifier = Modifier.padding(horizontal = 16.dp), color = Color.Gray)
        }
    }
}