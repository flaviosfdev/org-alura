package br.dev.flaviosf.org_alura.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.dev.flaviosf.org_alura.R
import br.dev.flaviosf.org_alura.databinding.ItemProductBinding
import br.dev.flaviosf.org_alura.model.Product
import br.dev.flaviosf.org_alura.utils.FormatCurrency
import br.dev.flaviosf.org_alura.utils.tryLoad
import coil.load

class ProductListAdapter(
    products: List<Product>,
    private val onClickProductItem: (product: Product) -> Unit,
    private val onClickEditItem: (product: Product) -> Unit,
    private val onClickDeleteItem: (product: Product) -> Unit
) : RecyclerView.Adapter<ProductListViewHolder>() {

    private val dataSet = products.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProductBinding.inflate(inflater, parent, false)
        return ProductListViewHolder(
            binding = binding,
            onClickProductItem = onClickProductItem,
            onClickEditItem = onClickEditItem,
            onClickDeleteItem = onClickDeleteItem)
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
}