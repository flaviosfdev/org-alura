package br.dev.flaviosf.org_alura.model

import java.math.BigDecimal

data class Product(
    val name: String,
    val description: String,
    val priceValue: BigDecimal,
    val image : String? = null
)
