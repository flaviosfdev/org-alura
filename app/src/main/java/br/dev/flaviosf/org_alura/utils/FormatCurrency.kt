package br.dev.flaviosf.org_alura.utils

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

class FormatCurrency {
    companion object {
        fun toBRL(value: BigDecimal): String {
            val currency = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
            return currency.format(value)
        }
    }
}