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

data class Hogar(
    val name: String, val imagen : Int, val precio:Double, val descripcion:String
)
@Composable
fun HogarItem(hogar:Hogar){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter =  painterResource(id = hogar.imagen),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
        )
        Text(text = hogar.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(text = hogar.descripcion, fontSize = 16.sp)
        Text(text = "Precio: ${hogar.precio}€", fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun Hogar(controladorNavegacion: NavHostController) {
    Text(text = "HOGAR", fontSize = 35.sp, fontWeight = FontWeight.Bold)//Titulo de la pagina
    val categorias= listOf(
        Hogar("Escritorio",R.drawable.escritorio,440.99,"Escritorio moderno. Muy práctico gracias a su parte rotativa al rededor de la estructura"),
        Hogar("Sofa",R.drawable.sofa,1489.00,"Sofa color gris para 4 personas, con espacio de almacenamiento en los reposabrazos"),
        Hogar("Lámpara",R.drawable.lampara,115.55,"Lampara de pies de pato muy luminosa")
    )
    LazyColumn {
        items(categorias) { hogar ->
            HogarItem(hogar = hogar)
            //separador entre cada elemento
            Divider(modifier = Modifier.padding(horizontal = 16.dp), color = Color.Gray)
        }
    }

}

