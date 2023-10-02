package com.catnip.egroceries.data.local.database.datasource

import com.catnip.egroceries.data.local.database.dao.ProductDao
import com.catnip.egroceries.data.local.database.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

interface ProductDataSource {
    fun getAllProducts(): Flow<List<ProductEntity>>
    fun getProductById(productId: Int): Flow<ProductEntity>
    suspend fun insertProducts(products: List<ProductEntity>): List<Long>
    suspend fun deleteProduct(product: ProductEntity): Int
    suspend fun updateProduct(product: ProductEntity): Int
}

class ProductDatabaseDataSource(private val dao: ProductDao) : ProductDataSource {
    override fun getAllProducts(): Flow<List<ProductEntity>> {
        return dao.getAllProducts()
    }

    override fun getProductById(productId: Int): Flow<ProductEntity> {
        return dao.getProductById(productId)
    }

    override suspend fun insertProducts(products: List<ProductEntity>): List<Long> {
        return dao.insertProducts(products)
    }

    override suspend fun deleteProduct(product: ProductEntity): Int {
        return dao.deleteProduct(product)
    }

    override suspend fun updateProduct(product: ProductEntity): Int {
        return dao.updateProduct(product)
    }

}
