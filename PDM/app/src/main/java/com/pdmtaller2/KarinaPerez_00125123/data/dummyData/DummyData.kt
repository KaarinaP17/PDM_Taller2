package com.pdmtaller2.KarinaPerez_00125123.data.dummyData

import com.pdmtaller2.KarinaPerez_00125123.data.Dish
import com.pdmtaller2.KarinaPerez_00125123.data.Restaurant

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
            ),
            Dish(
                id = 3,
                name = "Pizza Margherita",
                description = "Pizza tradicional italiana con tomate, mozzarella fresca y albahaca.",
                imageURL = "https://example.com/margherita.jpg"
            ),
            Dish(
                id = 4,
                name = "Pizza Hawaiana",
                description = "Pizza con jamón y piña, una mezcla única de sabores.",
                imageURL = "https://example.com/hawaiana.jpg"
            )
        )
    ),
    Restaurant(
        id = 2,
        name = "Burger King Kong",
        description = "Las hamburguesas más monstruosas",
        imageURL = "https://example.com/burger.jpg",
        category = listOf("Pizzas", "Comida Italiana", "Vegetariano"),
        menu = listOf(
            Dish(
                id = 3,
                name = "Hamburguesa Doble Queso",
                description = "Doble carne, doble queso, doble sabor.",
                imageURL = "https://example.com/doublecheese.jpg"
            ),
            Dish(
                id = 4,
                name = "Hamburguesa Vegana",
                description = "Una opción deliciosa y saludable.",
                imageURL = "https://example.com/veganburger.jpg"
            )
        )
    )
)
