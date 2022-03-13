package br.dev.flaviosf.org_alura

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val title = findViewById<TextView>(R.id.title)
        title.text = "Salada de frutas"

        val items = findViewById<TextView>(R.id.items)
        items.text = "Laranja, manga uva"

        val price = findViewById<TextView>(R.id.price)
        price.text = "19.99"


    }
}