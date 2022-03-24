package br.dev.flaviosf.org_alura.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import br.dev.flaviosf.org_alura.R
import br.dev.flaviosf.org_alura.dao.ProductDao
import br.dev.flaviosf.org_alura.databinding.ActivityProductListBinding
import br.dev.flaviosf.org_alura.ui.adapter.ProductListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProductListActivity : AppCompatActivity() {

    private val binding: ActivityProductListBinding by lazy { ActivityProductListBinding.inflate(layoutInflater) }
    private val dao = ProductDao()
    private val adapter : ProductListAdapter by lazy { ProductListAdapter(dao.getProducts()) }

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