package org.senac.boaviagem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {

    private lateinit var novaViagemButton : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        novaViagemButton = findViewById<ImageView>(R.id.iv_nova_viagem)
    }

    fun abrirFormViagem(view: View) {
        val intent = Intent(this, ViagemForm::class.java).apply {}
        startActivity(intent)
    }
}