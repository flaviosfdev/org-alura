package br.dev.flaviosf.org_alura.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.dev.flaviosf.org_alura.R
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
        //supportActionBar?.hide()
        setContentView(binding.root)
        getProduct()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_product_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_product_detail_edit -> {
                Toast.makeText(this, "editar item", Toast.LENGTH_SHORT).show()
            }
            R.id.menu_product_detail_delete -> {
                Toast.makeText(this, "deletar item", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }

    private fun getProduct() {
        intent.getParcelableExtra<Product>("product")?.let {
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