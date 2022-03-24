package br.dev.flaviosf.org_alura.dao

import br.dev.flaviosf.org_alura.model.Product

class ProductDao {

    fun add(product: Product) {
        products.add(product)
    }

    fun getProducts(): List<Product> {
        return products.toList()
    }

    companion object {
        private val products = mutableListOf<Product>()
    }

}