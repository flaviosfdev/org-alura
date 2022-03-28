package br.dev.flaviosf.org_alura.utils

import android.widget.ImageView
import br.dev.flaviosf.org_alura.R
import coil.load

fun ImageView.tryLoad(url: String? = null) {
    load(url) {
        // imagem nula
        fallback(R.drawable.default_image)
        // erro ao carregar imagem
        error(R.drawable.default_image)
        // enquanto a imagem está sendo carregada
        placeholder(R.drawable.placeholder)
    }
}