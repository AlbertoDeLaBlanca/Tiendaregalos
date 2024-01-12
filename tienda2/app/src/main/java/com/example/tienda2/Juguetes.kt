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

data class Juguetes(
    val name: String, val imagen : Int, val precio:Double, val descripcion:String
)
@Composable
fun JuguetesItem(juguetes: Juguetes) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Mostrar la foto utilizando el componente Image
        Image(
            painter = painterResource(id = juguetes.imagen),
            contentDescription = null, // Descripción de la imagen
            modifier = Modifier
                .size(150.dp) // Tamaño de la imagen
        )

        // Mostrar el nombre, descripción y precio
        Text(text = juguetes.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(text = juguetes.descripcion, fontSize = 16.sp)
        Text(text = "Precio: $${juguetes.precio}", fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun Juguetes (controladorNavegacion: NavHostController){
    Text(text = "HOGAR", fontSize = 35.sp, fontWeight = FontWeight.Bold)//Titulo de la pagina
    val categorias = listOf(
            Juguetes("Cubo de Rubik",R.drawable.rubik,25.99,"Rompecabezas para los mas atrevidos"),
            Juguetes("Lamborghini Huracan Lego", R.drawable.lambo, 52.99, "Lamborghini Huracan Técnica de lego, construye tu porpio lamborghini desde cero"),
            Juguetes("Scalextric",R.drawable.scalextric,144.95, "Scalextric original con coches gt, 5.2 metros de circuito")
    )

    LazyColumn {
        items(categorias) { juguetes ->
            JuguetesItem(juguetes = juguetes)
            //Separador entre elementos
            Divider(modifier = Modifier.padding(horizontal = 16.dp), color = Color.Gray)
        }
    }
}