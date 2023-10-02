package com.catnip.egroceries.data.local.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.catnip.egroceries.data.local.database.entity.CartEntity
import com.catnip.egroceries.data.local.database.entity.ProductEntity
import com.catnip.egroceries.data.local.database.relation.CartProductRelation
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {
    @Query("SELECT * FROM carts")
    fun getAllCarts() : Flow<List<CartEntity>>

    @Query("SELECT * FROM carts WHERE id == :cartId")
    fun getCartById(cartId: Int) : Flow<CartProductRelation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCarts(cart: List<CartEntity>): List<Long>

    @Delete
    suspend fun deleteCart(cart: CartEntity): Int

    @Update
    suspend fun updateCart(cart: CartEntity): Int

}