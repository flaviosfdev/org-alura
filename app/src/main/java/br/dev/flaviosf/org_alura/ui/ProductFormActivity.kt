package br.dev.flaviosf.org_alura.ui

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import br.dev.flaviosf.org_alura.R
import br.dev.flaviosf.org_alura.dao.ProductDao
import br.dev.flaviosf.org_alura.databinding.ActivityProductFormBinding
import br.dev.flaviosf.org_alura.databinding.ImageFormBinding
import br.dev.flaviosf.org_alura.model.Product
import br.dev.flaviosf.org_alura.ui.dialog.ImageFormDialog
import br.dev.flaviosf.org_alura.utils.tryLoad
import coil.load
import java.math.BigDecimal

class ProductFormActivity : AppCompatActivity() {

    private val binding: ActivityProductFormBinding by lazy {
        ActivityProductFormBinding.inflate(
            layoutInflater
        )
    }
    private var imageUrl: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = getString(R.string.register_product)
        setupSaveButton()

        binding.productFormImage.setOnClickListener {
            ImageFormDialog(this).showDialog(imageUrl) { url ->
                imageUrl = url
                binding.productFormImage.tryLoad(imageUrl)
            }
        }
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
        val price = binding.productFormPriceEdit.text.toString()
        return Product(
            name = binding.productFormNameEdit.text.toString(),
            description = binding.productFormDescriptionEdit.text.toString(),
            priceValue = if (price.isBlank()) BigDecimal.ZERO else BigDecimal(price),
            image = imageUrl
        )
    }

}