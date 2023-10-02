package com.catnip.egroceries.data.local.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.catnip.egroceries.data.local.database.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Query("SELECT * FROM products")
    fun getAllProducts(): Flow<List<ProductEntity>>

    @Query("SELECT * FROM products WHERE id == :productId")
    fun getProductById(productId: Int): Flow<ProductEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(products: List<ProductEntity>): List<Long>

    @Delete
    suspend fun deleteProduct(product: ProductEntity): Int

    @Update
    suspend fun updateProduct(product: ProductEntity): Int
}