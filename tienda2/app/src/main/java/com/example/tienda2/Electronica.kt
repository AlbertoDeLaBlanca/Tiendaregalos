package com.example.tienda2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

data class Electronica (
    val name: String, val imagen: Int, val precio:Double, val descripcion:String
)

@Composable
fun ElectronicaItem(electronica: Electronica) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Mostrar la foto utilizando el componente Image
        Image(
            painter = painterResource(id = electronica.imagen),
            contentDescription = null, // Descripción de la imagen
            modifier = Modifier
                .size(150.dp) // Tamaño de la imagen
        )

        // Mostrar el nombre, descripción y precio
        Text(text = electronica.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(text = electronica.descripcion, fontSize = 16.sp)
        Text(text = "Precio: $${electronica.precio}", fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun Electronica(controladorNavegacion: NavHostController) {
    Text(text = "ELECTRONICA", fontSize = 35.sp, fontWeight = FontWeight.Bold)//Titulo de la pagina
    val categorias= listOf(
            Electronica("Nintendo Switch",R.drawable.nintendo,276.99,"Consola de ultima generacion, adaptable para jugar en cualquier lado"),
            Electronica("Play Station 5",R.drawable.play,550.00, "Play Station 5, con temática de Spiderman"),
            Electronica("Lenovo Legion 5",R.drawable.lenovo,155.50,"Portatil gaming, Lenovo Legion 5 Pro 16IAH7H, 16'' WQXGA, Intel Core i7-12700H, 32GB RAM, 1TB SSD, GeForce RTX 3070")
        )

    LazyColumn {
        items(categorias) { electronica ->
            ElectronicaItem(electronica = electronica)
            //Separador entre elementos
            Divider(modifier = Modifier.padding(horizontal = 16.dp), color = Color.Gray)
        }
    }
}