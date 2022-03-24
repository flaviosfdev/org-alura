package br.dev.flaviosf.org_alura.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import br.dev.flaviosf.org_alura.R
import br.dev.flaviosf.org_alura.dao.ProductDao
import br.dev.flaviosf.org_alura.databinding.ActivityProductFormBinding
import br.dev.flaviosf.org_alura.model.Product
import java.math.BigDecimal

class ProductFormActivity : AppCompatActivity() {

    private val binding : ActivityProductFormBinding by lazy { ActivityProductFormBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupSaveButton()
    }

    private fun setupSaveButton() {
        val dao = ProductDao()
        binding.productFormSaveButton.setOnClickListener {
            val newProduct = newProduct()
            dao.add(newProduct)
            finish()
        }
    }

    private fun newProduct(): Product {
        val price = binding.productFormPrice.text.toString()
        return Product(
            name = binding.productFormName.text.toString(),
            description = binding.productFormDescription.text.toString(),
            price = if (price.isBlank()) BigDecimal.ZERO else BigDecimal(price)
        )
    }

}