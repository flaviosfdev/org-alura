package br.dev.flaviosf.org_alura.ui

import android.content.Intent
import android.os.Bundle
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.dev.flaviosf.org_alura.R
import br.dev.flaviosf.org_alura.database.AppDatabase
import br.dev.flaviosf.org_alura.databinding.ActivityProductListBinding
import br.dev.flaviosf.org_alura.model.Product
import br.dev.flaviosf.org_alura.ui.adapter.ProductListAdapter

class ProductListActivity : AppCompatActivity() {

    private val binding: ActivityProductListBinding by lazy {
        ActivityProductListBinding.inflate(layoutInflater)
    }
    private val db: AppDatabase by lazy { AppDatabase.instance(this) }
    private val adapter: ProductListAdapter by lazy {
        ProductListAdapter(
            db.productDao().getAll(),
            { onClickProductItem(it) },
            { onClickEditProductItem(it) },
            { onClickDeleteProductItem(it) }
        )
    }

    private fun onClickProductItem(product: Product) {
        val intent = Intent(this, ProductDetailActivity::class.java)
        intent.putExtra("product", product)
        startActivity(intent)
    }

    private fun onClickEditProductItem(product: Product) {
        Toast.makeText(this, "Editar ${product.name}", Toast.LENGTH_SHORT).show()
    }

    private fun onClickDeleteProductItem(product: Product) {
        Toast.makeText(this, "Deletar ${product.name}", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRecyclerView()
        setupFab()
    }

    private fun setupRecyclerView() {
        binding.productListRecycler.adapter = adapter
    }

    private fun setupFab() {
        binding.productListFab.setOnClickListener {
            goToProductForm()
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.update(db.productDao().getAll())
    }

    private fun goToProductForm() {
        val intent = Intent(this, ProductFormActivity::class.java)
        startActivity(intent)
    }

}