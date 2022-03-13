package br.dev.flaviosf.org_alura.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.dev.flaviosf.org_alura.R
import br.dev.flaviosf.org_alura.model.Product

class ProductListAdapter(
    private val productList: List<Product>
) : RecyclerView.Adapter<ProductListAdapter.ProductListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_product, parent, false)
        return ProductListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        val product = productList[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int = productList.size

    class ProductListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.name)
        val description = itemView.findViewById<TextView>(R.id.description)
        val price = itemView.findViewById<TextView>(R.id.price)

        fun bind(product: Product) {
            name.text = product.name
            description.text = product.description
            price.text = product.price.toPlainString()

        }


    }
}