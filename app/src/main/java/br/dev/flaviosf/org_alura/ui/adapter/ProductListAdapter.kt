package br.dev.flaviosf.org_alura.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.dev.flaviosf.org_alura.R
import br.dev.flaviosf.org_alura.databinding.ItemProductBinding
import br.dev.flaviosf.org_alura.model.Product
import coil.load
import java.text.NumberFormat
import java.util.*

class ProductListAdapter(products: List<Product>) :
    RecyclerView.Adapter<ProductListAdapter.ProductListViewHolder>() {

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

    class ProductListViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            val currency = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
            binding.itemProductName.text = product.name
            binding.itemProductDescription.text = product.description
            binding.itemProductPrice.text = currency.format(product.priceValue)
            binding.itemProductImage.load(R.drawable.default_image)

            binding.itemProductImage.visibility = when(product.image) {
                null -> { View.GONE }
                else -> {
                    binding.itemProductImage.load(product.image) {
                        fallback(R.drawable.default_image)
                        error(R.drawable.default_image)
                    }
                    View.VISIBLE
                }
            }

        }


    }
}