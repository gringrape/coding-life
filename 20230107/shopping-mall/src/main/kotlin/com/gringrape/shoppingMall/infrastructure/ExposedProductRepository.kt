package com.gringrape.shoppingMall.infrastructure

import com.gringrape.shoppingMall.domain.Product
import com.gringrape.shoppingMall.domain.ProductRepository
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.springframework.stereotype.Repository

@Repository
class ExposedProductRepository : ProductRepository {

    override fun findAll(): List<Product> {
        return Products.selectAll().map { toProduct(it) }
    }

    override fun findById(id: Long): Product? {
        return Products.select { Products.id eq id }
            .map { toProduct(it) }.firstOrNull()
    }

    fun toProduct(row: ResultRow): Product {
        return Product(
            id = row[Products.id],
            name = row[Products.name],
            price = row[Products.price],
            stockQuantity = row[Products.stockQuantity]
        )
    }

}
