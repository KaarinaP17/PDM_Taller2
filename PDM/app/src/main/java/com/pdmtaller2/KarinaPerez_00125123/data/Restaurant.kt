package com.pdmtaller2.KarinaPerez_00125123.data

import kotlinx.serialization.Serializable

@Serializable
data class Restaurant(
    val id: Int,
    val name: String,
    val description: String,
    val imageURL: String,
    val category: List<String>,
    val menu: List<Dish>
)
