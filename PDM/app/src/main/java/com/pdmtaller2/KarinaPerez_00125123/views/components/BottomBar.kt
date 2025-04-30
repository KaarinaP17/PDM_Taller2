package com.pdmtaller2.KarinaPerez_00125123.views.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun BottomBar(modifier: Modifier = Modifier, onHome: ()->Unit = {}, onSearch: ()->Unit = {}, onMyOrders: ()->Unit = {}) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        BottomBarItem(icon = Icons.Filled.Home, label = "Home"){
            onHome()
        }
        BottomBarItem(icon = Icons.Filled.Search, label = "Search"){
            onSearch()
        }
        BottomBarItem(icon = Icons.Filled.ShoppingCart, label = "My Orders"){
            onMyOrders()
        }
    }
}

@Composable
fun BottomBarItem(icon: ImageVector, label: String, onClick: ()->Unit= {}) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable{
            onClick()
        }
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
@Preview (showBackground = true, showSystemUi = true)
fun BottomBarPreview() {
    BottomBar()
}