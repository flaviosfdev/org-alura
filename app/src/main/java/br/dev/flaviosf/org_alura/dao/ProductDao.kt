package br.dev.flaviosf.org_alura.dao

import br.dev.flaviosf.org_alura.model.Product
import java.math.BigDecimal

class ProductDao {

    fun add(product: Product) {
        products.add(product)
    }

    fun getProducts(): List<Product> {
        return products.toList()
    }

    companion object {
        private val products = mutableListOf(
            Product(
                name = "Cesta de frutas",
                description = "Laranja, maçã, banana, pêra, morango e uva",
                price = BigDecimal("19.90")
            )
        )
    }

}