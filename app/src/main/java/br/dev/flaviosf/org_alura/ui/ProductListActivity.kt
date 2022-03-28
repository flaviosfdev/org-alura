package br.dev.flaviosf.org_alura.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.dev.flaviosf.org_alura.dao.ProductDao
import br.dev.flaviosf.org_alura.databinding.ActivityProductListBinding
import br.dev.flaviosf.org_alura.model.Product
import br.dev.flaviosf.org_alura.ui.adapter.ProductListAdapter
import br.dev.flaviosf.org_alura.ui.dialog.ImageFormDialog

class ProductListActivity : AppCompatActivity() {

    private val binding: ActivityProductListBinding by lazy {
        ActivityProductListBinding.inflate(
            layoutInflater
        )
    }
    private val dao = ProductDao()
    private val adapter: ProductListAdapter by lazy { ProductListAdapter(dao.getProducts()) { onClick(it) } }

    private fun onClick(product: Product) {
        val intent = Intent(this, ProductDetailActivity::class.java)
        intent.putExtra("product", product)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRecyclerView()
        setupFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.update(dao.getProducts())
    }

    private fun setupFab() {
        binding.productListFab.setOnClickListener {
            goToProductForm()
        }
    }

    private fun goToProductForm() {
        val intent = Intent(this, ProductFormActivity::class.java)
        startActivity(intent)
    }

    private fun setupRecyclerView() {
        binding.productListRecycler.adapter = adapter
    }

}