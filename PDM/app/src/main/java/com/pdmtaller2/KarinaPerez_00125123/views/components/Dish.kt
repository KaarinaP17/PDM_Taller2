package com.pdmtaller2.KarinaPerez_00125123.views.components

import androidx.compose.runtime.Composable
import coil.compose.AsyncImage
import com.pdmtaller2.KarinaPerez_00125123.data.Dish
import com.pdmtaller2.KarinaPerez_00125123.views.SearchScreen

@Composable
fun DishCard(
    name: String,
    description: String,
    imageUrl: String,
    onAddClick: @Composable () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = "platillo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Nombre del platillo
            Text(
                text = name,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 4.dp)
            )

            // Descripción breve del platillo
            Text(
                text = description,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Botón de agregar
            Button(
                onClick = onAddClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Agregar")
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun DishPreview() {
    Dish("hola", "hola", "hola") {}
}