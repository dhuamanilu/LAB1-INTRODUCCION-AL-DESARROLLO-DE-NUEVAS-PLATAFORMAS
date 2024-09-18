package com.example.lab1_epropuesto_login

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicializar el binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        // Botón para guardar los datos en un archivo de texto
        btnGuardar.setOnClickListener {
            saveDataToFile()
        }
    }
    // Función para guardar los datos en un archivo de texto
    private fun saveDataToFile() {
        // Obtener los datos de los EditText
        val username = binding.edtUsername.text.toString()
        val password = binding.edtPassword.text.toString()
        val email = binding.edtEmail.text.toString()
        val phoneNumber = binding.edtNumber.text.toString()
        val bloodGroup = binding.edtBloodGroup.text.toString()
        Log.d(username,password)
    }
}