package com.catnip.egroceries.data.local.database.datasource

import com.catnip.egroceries.data.local.database.dao.CartDao
import com.catnip.egroceries.data.local.database.entity.CartEntity
import com.catnip.egroceries.data.local.database.entity.ProductEntity
import com.catnip.egroceries.data.local.database.relation.CartProductRelation
import kotlinx.coroutines.flow.Flow

interface CartDataSource {
    fun getAllCarts(): Flow<List<CartEntity>>
    fun getCartById(cartId: Int): Flow<CartProductRelation>
    suspend fun insertCarts(cart: List<CartEntity>): List<Long>
    suspend fun deleteCart(cart: CartEntity): Int
    suspend fun updateCart(cart: CartEntity): Int
}

class CartDatabaseDataSource(private val dao: CartDao) : CartDataSource{
    override fun getAllCarts(): Flow<List<CartEntity>> {
        return dao.getAllCarts()
    }

    override fun getCartById(cartId: Int): Flow<CartProductRelation> {
        return dao.getCartById(cartId)
    }

    override suspend fun insertCarts(cart: List<CartEntity>): List<Long> {
        return dao.insertCarts(cart)
    }

    override suspend fun deleteCart(cart: CartEntity): Int {
        return dao.deleteCart(cart)
    }

    override suspend fun updateCart(cart: CartEntity): Int {
        return dao.deleteCart(cart)
    }

}