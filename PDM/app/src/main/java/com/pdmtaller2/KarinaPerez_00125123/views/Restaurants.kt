package com.pdmtaller2.KarinaPerez_00125123.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pdmtaller2.KarinaPerez_00125123.data.Dish
import com.pdmtaller2.KarinaPerez_00125123.data.Restaurant
import com.pdmtaller2.KarinaPerez_00125123.views.components.BottomBar
import com.pdmtaller2.KarinaPerez_00125123.views.components.TitleComponent
import coil.compose.AsyncImage

@Composable
fun Restaurants() {
    val restaurants = listOf(
        Restaurant(
            id = 1,
            name = "Pizza Planet",
            description = "Las mejores pizzas del universo",
            imageURL = "https://example.com/pizza.jpg",
            category = listOf("Pizzas", "Comida Italiana", "Vegetariano"),
            menu = listOf(
                Dish(
                    id = 1,
                    name = "Pizza Pepperoni",
                    description = "Clásica pizza con pepperoni y queso.",
                    imageURL = "https://example.com/pepperoni.jpg"
                ),
                Dish(
                    id = 2,
                    name = "Pizza Vegetariana",
                    description = "Pizza saludable con verduras frescas.",
                    imageURL = "https://example.com/veggie.jpg"
                )
            )
        ),
        Restaurant(
            id = 2,
            name = "Burger King Kong",
            description = "Las hamburguesas más monstruosas",
            imageURL = "https://example.com/burger.jpg",
            category = listOf("Hamburguesas", "Comida Rápida"),
            menu = listOf(
                Dish(
                    id = 1,
                    name = "Burger Clásico",
                    description = "Hamburguesa con carne jugosa y queso.",
                    imageURL = "https://example.com/burgerclassico.jpg"
                )
            )
        )
    )

    Scaffold(
        topBar = { TitleComponent(title = "FootSpot") },
        bottomBar = { BottomBar() }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            item {
                Text(
                    text = "Comida Rápida",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(16.dp)
                )
            }
            restaurants.filter { it.category.contains("Comida Rápida") }.forEach { restaurant ->
                item {
                    RestaurantRow(restaurant = restaurant)
                }
            }

            item {
                Text(
                    text = "Comida Italiana",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(16.dp)
                )
            }
            restaurants.filter { it.category.contains("Comida Italiana") }.forEach { restaurant ->
                item {
                    RestaurantRow(restaurant = restaurant)
                }
            }
        }
    }
}

@Composable
fun RestaurantRow(restaurant: Restaurant) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = restaurant.name,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(restaurant.menu) { dish ->
                DishCard(dish)
            }
        }
    }
}

@Composable
fun RestaurantCard(restaurant: Restaurant) {
    Card(
        modifier = Modifier
            .width(150.dp)
            .height(200.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(8.dp)
        ) {

            AsyncImage(
                model = restaurant.imageURL,
                contentDescription = "platillo"
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = restaurant.name, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(4.dp))

            Text(text = restaurant.description, style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { showToast(dish.name) }) {
                Text(text = "Agregar al carrito")
            }
        }
    }
}

//Implementación del Toast
@Composable
fun showToast(dishName: String) {
    val context = LocalContext.current
    LaunchedEffect(dishName) {
        Toast.makeText(context, "$dishName agregado al carrito", Toast.LENGTH_SHORT).show()
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun RestaurantsPreview() {
    Restaurants()
}