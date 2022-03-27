package br.dev.flaviosf.org_alura.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import br.dev.flaviosf.org_alura.R
import br.dev.flaviosf.org_alura.dao.ProductDao
import br.dev.flaviosf.org_alura.databinding.ActivityProductFormBinding
import br.dev.flaviosf.org_alura.databinding.ImageFormBinding
import br.dev.flaviosf.org_alura.model.Product
import coil.load
import java.math.BigDecimal
import kotlinx.coroutines.delay

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
        setupSaveButton()

        binding.productFormImage.setOnClickListener {
            imageUrl = null
            val bindingImageForm = ImageFormBinding.inflate(layoutInflater)

            with(bindingImageForm) {
                imageFormRefreshButton.setOnClickListener {
                    if (imageFormUrlEdit.text.toString().isBlank().not()) {
                        imageUrl = imageFormUrlEdit.text.toString()
                        imageFormPhoto.load(imageUrl) {
                            // imagem nula
                            fallback(R.drawable.default_image)
                            // erro ao carregar imagem
                            error(R.drawable.default_image)
                            // enquanto a imagem está sendo carregada
                            //placeholder(R.drawable.default_image)
                        }
                    }
                    imageFormUrlEdit.text?.clear()
                }
            }

            AlertDialog.Builder(this)
                .setView(bindingImageForm.root)
                .setPositiveButton(getString(R.string.confirm)) { _, _ ->
                    binding.productFormImage.load(imageUrl) {
                        fallback(R.drawable.default_image)
                        error(R.drawable.default_image)
                    }
                }
                .setNegativeButton(getString(R.string.cancel)) { _, _ ->
                }
                .show()
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