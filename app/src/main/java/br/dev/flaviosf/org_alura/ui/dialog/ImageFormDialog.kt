package br.dev.flaviosf.org_alura.ui.dialog

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import br.dev.flaviosf.org_alura.R
import br.dev.flaviosf.org_alura.databinding.ImageFormBinding
import br.dev.flaviosf.org_alura.utils.tryLoad

class ImageFormDialog(private val context: Context) {
    private var imageUrl: String? = null

    fun showDialog(
        defaultUrl: String? = null,
        confirmOnClick: (url: String?) -> Unit
    ) {

        ImageFormBinding.inflate(LayoutInflater.from(context)).apply {

            defaultUrl?.let {
                imageFormPhoto.tryLoad(it)
                imageFormUrlEdit.setText(it)
                imageUrl = it
            }

            imageFormRefreshButton.setOnClickListener {
                imageUrl = imageFormUrlEdit.text.toString()
                imageFormPhoto.tryLoad(imageUrl)
            }

            AlertDialog.Builder(context)
                .setView(root)
                .setPositiveButton(R.string.confirm) { _, _ ->

                    confirmOnClick(imageUrl)
                }
                .show()
        }
    }
}
