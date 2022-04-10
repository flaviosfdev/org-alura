package br.dev.flaviosf.org_alura.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.dev.flaviosf.org_alura.model.Product

@Dao
interface ProductDao {

    @Query("SELECT * FROM Product")
    fun getAll(): List<Product>

    @Insert
    fun saveProduct(product: Product)

}