package br.dev.flaviosf.org_alura.model

import android.os.Parcelable
import androidx.room.Entity
import java.math.BigDecimal
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Product(
    val name: String,
    val description: String,
    val priceValue: BigDecimal,
    val image: String? = null
) : Parcelable