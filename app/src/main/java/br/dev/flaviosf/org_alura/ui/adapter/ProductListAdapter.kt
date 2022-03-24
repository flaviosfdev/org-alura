package br.dev.flaviosf.org_alura.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.dev.flaviosf.org_alura.R
import br.dev.flaviosf.org_alura.databinding.ItemProductBinding
import br.dev.flaviosf.org_alura.model.Product

class ProductListAdapter(products: List<Product>) : RecyclerView.Adapter<ProductListAdapter.ProductListViewHolder>() {

    private val dataSet = products.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProductBinding.inflate(inflater, parent, false)
        return ProductListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        val product = dataSet[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int = dataSet.size

    fun update(products: List<Product>) {
        dataSet.clear()
        dataSet.addAll(products)
        notifyDataSetChanged()
    }

    class ProductListViewHolder(private val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            binding.itemProductName.text = product.name
            binding.itemProductDescription.text = product.description
            binding.itemProductPrice.text = product.price.toPlainString()

        }


    }
}