package com.pdmtaller2.KarinaPerez_00125123.views

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.pdmtaller2.KarinaPerez_00125123.data.Restaurant
import com.pdmtaller2.KarinaPerez_00125123.views.components.BottomBar
import com.pdmtaller2.KarinaPerez_00125123.views.components.DishCard
import com.pdmtaller2.KarinaPerez_00125123.views.components.SearchBar
import com.pdmtaller2.KarinaPerez_00125123.views.components.TitleComponent

@Composable
fun DishScreen(restaurant: Restaurant, onRestaurant: ()->Unit = {}, onMyOrders: ()->Unit = {}, onSearch: ()->Unit = {}) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomBar(
                modifier = Modifier.padding(16.dp),
                onHome = onRestaurant,
                onSearch = onSearch,
                onMyOrders = onMyOrders
            )
        },
        topBar = {
            TitleComponent(
                title = restaurant.name
            )
        }
    ) { innerPadding ->
        LazyColumn (
            modifier = Modifier.padding(innerPadding)
                .fillMaxSize()
        ) {
           item {
               var searchText by remember { mutableStateOf("") }
               SearchBar(text = searchText, onTextChange = {searchText = it}, onSearch = {})
           }
            items(restaurant.menu){
                DishCard(it.name, it.description, it.imageURL) { showToast(it.name) }
            }
        }
    }
}

@Composable
fun showToast(dishName: String) {
    val context = LocalContext.current
    LaunchedEffect(dishName) {
        Toast.makeText(context, "$dishName agregado al carrito", Toast.LENGTH_SHORT).show()
    }
}