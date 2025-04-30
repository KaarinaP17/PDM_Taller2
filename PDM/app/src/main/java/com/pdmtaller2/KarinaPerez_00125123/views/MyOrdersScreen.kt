package com.pdmtaller2.KarinaPerez_00125123.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pdmtaller2.KarinaPerez_00125123.views.components.BottomBar
import com.pdmtaller2.KarinaPerez_00125123.views.components.TitleComponent

@Composable
fun MyOrdersScreen(
    onRestaurant: ()->Unit = {},
    onMyOrders: ()->Unit = {},
    onSearch: ()->Unit = {}
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TitleComponent(
                title = "My Orders",
                modifier = Modifier.padding(16.dp)
            )
        },
        bottomBar = {
            BottomBar(
                modifier = Modifier.padding(16.dp),
                onHome = onRestaurant,
                onSearch = onSearch,
                onMyOrders = onMyOrders
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                // Content goes here
            }
        }
    )
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun MyOrderScreenPreview(){
    MyOrdersScreen()
}