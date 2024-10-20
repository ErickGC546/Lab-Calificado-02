package com.galindo.erick.laboratoriocalificado02

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class Ejercicio01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio01)

        // Los botones y la vista verde
        val verdeView: View = findViewById(R.id.verdeView)
        val mostrarButton: Button = findViewById(R.id.mostrarButton)
        val ocultarButton: Button = findViewById(R.id.ocultarButton)

        // Funcion para mostrar la vista verde
        mostrarButton.setOnClickListener {
            verdeView.visibility = View.VISIBLE
        }

        // Funcion para ocultar la vista verde
        ocultarButton.setOnClickListener {
            verdeView.visibility = View.GONE
        }
    }
}