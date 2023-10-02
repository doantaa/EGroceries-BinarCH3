package com.catnip.egroceries.model

data class Cart(
    val id: Int? = 0,
    val productId: Int = 0,
    val itemQuantity: Int = 0,
    val itemNotes: String? = null
)
