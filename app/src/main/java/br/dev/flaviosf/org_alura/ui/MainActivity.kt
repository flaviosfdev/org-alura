package br.dev.flaviosf.org_alura.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import br.dev.flaviosf.org_alura.R
import br.dev.flaviosf.org_alura.model.Product
import br.dev.flaviosf.org_alura.ui.adapter.ProductListAdapter
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerProducts = findViewById<RecyclerView>(R.id.recycler)
        recyclerProducts.adapter = ProductListAdapter(
            List(15) {
                Product(
                    name = "Abacate",
                    description = "Abacate verde",
                    price = BigDecimal("19.99")
                )
            }
        )


    }
}