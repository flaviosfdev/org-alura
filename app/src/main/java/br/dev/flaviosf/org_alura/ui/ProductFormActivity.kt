package br.dev.flaviosf.org_alura.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import br.dev.flaviosf.org_alura.R
import br.dev.flaviosf.org_alura.dao.ProductDao
import br.dev.flaviosf.org_alura.model.Product
import java.math.BigDecimal

class ProductFormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_form)
        setupSaveButton()
    }

    private fun setupSaveButton() {
        val saveButton: Button = findViewById(R.id.product_form_save_button)
        val dao = ProductDao()

        saveButton.setOnClickListener {
            val newProduct = newProduct()
            dao.add(newProduct)
            finish()
        }
    }

    private fun newProduct(): Product {
        val nameField: EditText = findViewById(R.id.product_form_name)
        val name = nameField.text.toString()

        val descriptionField: EditText = findViewById(R.id.product_form_description)
        val description = descriptionField.text.toString()

        val priceField: EditText = findViewById(R.id.product_form_price)
        val price = priceField.text.toString()

        return Product(
            name = name,
            description = description,
            price = if (price.isBlank()) BigDecimal.ZERO else BigDecimal(price)
        )
    }

}