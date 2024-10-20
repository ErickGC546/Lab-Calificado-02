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
            // Asegúrate de que telefonoCliente tenga un valor válido
            val telefonoCliente = intent.getStringExtra("telefonoCliente") ?: ""
            val phone = "+51$telefonoCliente"  // Prepend el código de país si es necesario
            val mensaje = "Hola $nombreCliente, Tus productos: $productos están en camino a la dirección: $direccion"

            // Crear la intención para WhatsApp
            val intentWsp = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://wa.me/$phone?text=${Uri.encode(mensaje)}")
            }

            startActivity(intentWsp)
        }

        // Botón para abrir Google Maps con la dirección del cliente
        binding.imbmaps.setOnClickListener {
            val intentMaps = Intent(Intent.ACTION_VIEW)
            intentMaps.data = Uri.parse("https://www.google.com/maps/search/?api=1&query=${Uri.encode(direccion)}")
            startActivity(intentMaps)
        }
    }
}

