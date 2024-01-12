package com.example.tienda2.ui.theme

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
import com.example.tienda2.Juguetes
import com.example.tienda2.R

data class Cocina(
    val name: String, val imagen : Int, val precio:Double, val descripcion:String
)
@Composable
fun CocinaItem(cocina: Juguetes) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Mostrar la foto utilizando el componente Image
        Image(
            painter = painterResource(id = cocina.imagen),
            contentDescription = null, // Descripción de la imagen
            modifier = Modifier
                .size(150.dp) // Tamaño de la imagen
        )

        // Mostrar el nombre, descripción y precio
        Text(text = cocina.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(text = cocina.descripcion, fontSize = 16.sp)
        Text(text = "Precio: $${cocina.precio}", fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun Cocina (controladorNavegacion: NavHostController){
    Text(text = "COCINA", fontSize = 35.sp, fontWeight = FontWeight.Bold)//Titulo de la pagina

    val categorias = listOf(
        Juguetes("Juego de Sartenes",R.drawable.sarten,27.99,"Juego de tres sartenes de acero"),
        Juguetes("Thermomix", R.drawable.thermomix, 1498.99, "Robot de cocina de última generación"),
        Juguetes("AirFryer", R.drawable.airfreyer,69.54, "Freidora de Aire")
    )

    LazyColumn {
        items(categorias) { cocina ->
            CocinaItem(cocina = cocina)
            //Separador entre elementos
            Divider(modifier = Modifier.padding(horizontal = 16.dp), color = Color.Gray)
        }
    }
}