package com.pdmtaller2.KarinaPerez_00125123

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pdmtaller2.KarinaPerez_00125123.data.Restaurant
import com.pdmtaller2.KarinaPerez_00125123.ui.theme.FoodSpotByKperezTheme
import com.pdmtaller2.KarinaPerez_00125123.views.DishScreen
import com.pdmtaller2.KarinaPerez_00125123.views.MyOrdersScreen
import com.pdmtaller2.KarinaPerez_00125123.views.Restaurants
import com.pdmtaller2.KarinaPerez_00125123.views.SearchScreen
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodSpotByKperezTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "restaurants",
                ) {
                    composable("restaurants") {
                        Restaurants(
                            onRestaurant = { navController.navigate("restaurants") },
                            onMyOrders = { navController.navigate("orders") },
                            onSearch = { navController.navigate("search") }
                        )
                    }
                    composable("orders") {
                        MyOrdersScreen(
                            onRestaurant = { navController.navigate("restaurants") },
                            onMyOrders = { navController.navigate("orders") },
                            onSearch = { navController.navigate("search") }
                        )
                    }
                    composable("search") {
                        SearchScreen(
                            onRestaurant = { navController.navigate("restaurants") },
                            onMyOrders = { navController.navigate("orders") },
                            onSearch = { navController.navigate("search") }
                        )
                    }
                    composable(
                        "restaurantDetail/{restaurant}",
                        arguments = listOf(navArgument("restaurant") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val data = backStackEntry.arguments?.getString("restaurant") ?: ""
                        val restaurant = Json.decodeFromString<Restaurant>(data)
                        DishScreen(restaurant)
                    }
                }
            }
        }
    }
}