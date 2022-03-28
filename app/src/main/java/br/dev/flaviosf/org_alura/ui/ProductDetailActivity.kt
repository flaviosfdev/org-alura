package br.dev.flaviosf.org_alura.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.dev.flaviosf.org_alura.databinding.ActivityProductDetailBinding
import br.dev.flaviosf.org_alura.model.Product
import br.dev.flaviosf.org_alura.utils.FormatCurrency
import br.dev.flaviosf.org_alura.utils.tryLoad

class ProductDetailActivity : AppCompatActivity() {

    private val binding: ActivityProductDetailBinding by lazy {
        ActivityProductDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(binding.root)
        getProduct()
    }

    private fun getProduct() {
        intent.getParcelableExtra<Product>("product")?. let {
            bindProductDetail(it)
        } ?: finish()
    }

    private fun bindProductDetail(product: Product) {
        binding.apply {
            productDetailImg.tryLoad(product.image)
            productDetailName.text = product.name
            productDetailDescription.text = product.description
            productDetailPrice.text = FormatCurrency.toBRL(product.priceValue)
        }
    }

}