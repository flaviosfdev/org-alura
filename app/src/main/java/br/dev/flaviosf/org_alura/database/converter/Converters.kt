package br.dev.flaviosf.org_alura.database.converter

import androidx.room.TypeConverter
import java.math.BigDecimal

class Converters {

    @TypeConverter
    fun doubleToBigDecimal(value : Double?) : BigDecimal {
        return value?.let { BigDecimal(value.toString()) } ?: BigDecimal.ZERO
    }

    @TypeConverter
    fun bigDecimalToDouble(value : BigDecimal?) : Double? {
        return value?.let { value.toDouble() }
    }

}