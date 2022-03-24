package br.dev.flaviosf.org_alura.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.dev.flaviosf.org_alura.R
import br.dev.flaviosf.org_alura.model.Product

class ProductListAdapter(products: List<Product>) : RecyclerView.Adapter<ProductListAdapter.ProductListViewHolder>() {

    private val dataSet = products.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_product, parent, false)
        return ProductListViewHolder(view)
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

    class ProductListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.item_product_name)
        val description = itemView.findViewById<TextView>(R.id.item_product_description)
        val price = itemView.findViewById<TextView>(R.id.item_product_price)

        fun bind(product: Product) {
            name.text = product.name
            description.text = product.description
            price.text = product.price.toPlainString()

        }


    }
}