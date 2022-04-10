package br.dev.flaviosf.org_alura.ui.adapter

import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import br.dev.flaviosf.org_alura.R
import br.dev.flaviosf.org_alura.databinding.ItemProductBinding
import br.dev.flaviosf.org_alura.model.Product
import br.dev.flaviosf.org_alura.utils.FormatCurrency
import br.dev.flaviosf.org_alura.utils.tryLoad
import coil.load

class ProductListViewHolder(
    private val binding: ItemProductBinding,
    private val onClickProductItem: (product: Product) -> Unit,
    private val onClickEditItem: (product: Product) -> Unit,
    private val onClickDeleteItem: (product: Product) -> Unit
) : RecyclerView.ViewHolder(binding.root), PopupMenu.OnMenuItemClickListener {

    private var product: Product? = null

    fun bind(product: Product) {
        this.product = product
        binding.itemProductName.text = product.name
        binding.itemProductDescription.text = product.description
        binding.itemProductPrice.text = FormatCurrency.toBRL(product.priceValue)
        binding.itemProductImage.load(R.drawable.default_image)

        binding.itemProductImage.visibility = when (product.image) {
            null -> {
                View.GONE
            }
            else -> {
                binding.itemProductImage.tryLoad(product.image)
                View.VISIBLE
            }
        }

        binding.root.setOnClickListener { onClickProductItem(product) }
        binding.root.setOnLongClickListener {
            showPopup(it)
            true
        }
    }

    private fun showPopup(v: View) {
        PopupMenu(binding.root.context, v).apply {
            inflate(R.menu.menu_product_detail)
            setOnMenuItemClickListener(this@ProductListViewHolder::onMenuItemClick)
            show()
        }
    }

    override fun onMenuItemClick(item: MenuItem): Boolean = when (item.itemId) {
        R.id.menu_product_detail_edit -> {
            product?.let { onClickEditItem(it) }
            true
        }
        R.id.menu_product_detail_delete -> {
            product?.let { onClickDeleteItem(it) }
            true
        }
        else -> false
    }
}