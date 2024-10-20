package com.galindo.erick.laboratoriocalificado02

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.galindo.erick.laboratoriocalificado02.databinding.ActivityEjercicio02Binding

class Ejercicio02 : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio02Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio02Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtener los datos que se pasaron desde la actividad anterior
        val nombreCliente = intent.getStringExtra("nombreCliente")
        val telefonoCliente = intent.getStringExtra("telefonoCliente")
        val productos = intent.getStringExtra("productos")
        val direccion = intent.getStringExtra("direccion")

        // Mostrar los datos en los TextViews de esta nueva interfaz
        binding.nombreClienteText.text = nombreCliente
        binding.telefonoClienteText.text = telefonoCliente
        binding.productosText.text = productos
        binding.direccionText.text = direccion

        // Botón para hacer una llamada
        binding.imbTelefono.setOnClickListener {
            val intentLlamar = Intent(Intent.ACTION_DIAL)
            intentLlamar.data = Uri.parse("tel:$telefonoCliente")
            startActivity(intentLlamar)
        }

        // Botón para enviar mensaje de WhatsApp
        binding.imbWsp.setOnClickListener {
            val mensaje = "Hola $nombreCliente, Tus productos: $productos están en camino a la dirección: $direccion."

            val intentWhatsApp = Intent(Intent.ACTION_SEND)
            intentWhatsApp.type = "text/plain"
            intentWhatsApp.putExtra(Intent.EXTRA_TEXT, mensaje)
            intentWhatsApp.setPackage("com.whatsapp")  // Asegurarse de que solo abra WhatsApp

            if (intentWhatsApp.resolveActivity(packageManager) != null) {
                startActivity(intentWhatsApp)
            } else {
                // Mostrar mensaje si WhatsApp no está instalado
                Toast.makeText(this, "WhatsApp no está instalado", Toast.LENGTH_SHORT).show()
            }
        }

        // Botón para abrir Google Maps con la dirección del cliente
        binding.imbmaps.setOnClickListener {
            val intentMaps = Intent(Intent.ACTION_VIEW)
            intentMaps.data = Uri.parse("geo:0,0?q=$direccion")

            if (intentMaps.resolveActivity(packageManager) != null) {
                startActivity(intentMaps)
            } else {
                // Mostrar mensaje si Google Maps no está instalado
                Toast.makeText(this, "Google Maps no está instalado", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

