package com.catnip.egroceries.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "carts")
data class CartEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,

    @ColumnInfo(name = "product_id")
    val productId: Int = 0,

    @ColumnInfo(name = "item_quantity")
    val itemQuantity: Int = 0,

    @ColumnInfo(name = "item_notes")
    val itemNotes: String? = null
)