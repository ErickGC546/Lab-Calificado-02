package com.galindo.erick.laboratoriocalificado02

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.galindo.erick.laboratoriocalificado02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar el botón "Registrar"
        binding.registrarButton.setOnClickListener {
            // Obtener los datos del formulario
            val nombreCliente = binding.nombreClienteInput.text.toString()
            val telefonoCliente = binding.telefonoClienteInput.text.toString()
            val productos = binding.productosInput.text.toString()
            val direccion = binding.direccionInput.text.toString()

            // Crear el Intent para cambiar a la nueva actividad
            val intent = Intent(this, Ejercicio02::class.java)

            // Pasar los datos a la nueva actividad
            intent.putExtra("nombreCliente", nombreCliente)
            intent.putExtra("telefonoCliente", telefonoCliente)
            intent.putExtra("productos", productos)
            intent.putExtra("direccion", direccion)

            // Iniciar la nueva actividad
            startActivity(intent)
        }
    }
}
}