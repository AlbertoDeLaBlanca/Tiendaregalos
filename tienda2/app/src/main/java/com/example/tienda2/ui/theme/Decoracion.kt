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

data class Decoracion(
    val name: String, val imagen : Int, val precio:Double, val descripcion:String
)
@Composable
fun DecoracionItem(decoracion: Juguetes) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Mostrar la foto utilizando el componente Image
        Image(
            painter = painterResource(id = decoracion.imagen),
            contentDescription = null, // Descripción de la imagen
            modifier = Modifier
                .size(150.dp) // Tamaño de la imagen
        )

        // Mostrar el nombre, descripción y precio
        Text(text = decoracion.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(text = decoracion.descripcion, fontSize = 16.sp)
        Text(text = "Precio: $${decoracion.precio}", fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun Decoracion (controladorNavegacion: NavHostController){
    Text(text = "DECORACION", fontSize = 35.sp, fontWeight = FontWeight.Bold)//Titulo de la pagina

    val categorias = listOf(
        Juguetes("Cuadro",R.drawable.cuadro,40.99,"Cuadro de arbol dorado sobre fondo negro"),
        Juguetes("Puff", R.drawable.puff, 14.99, "Puff")
    )

    LazyColumn {
        items(categorias) { decoracion ->
            DecoracionItem(decoracion = decoracion)
            //Separador entre elementos
            Divider(modifier = Modifier.padding(horizontal = 16.dp), color = Color.Gray)
        }
    }
}