package com.example.lab1_epropuesto_login

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab1_epropuesto_login.databinding.ActivityMainBinding
import android.widget.Toast
import java.io.IOException
import java.io.File
import java.io.FileOutputStream
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicializar el binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val btnGuardar=binding.btnGuardar
        btnGuardar.setOnClickListener {
            saveDataToFile()
        }
        val btnMostrarDatos=binding.btnMostrarDatos
        btnMostrarDatos.setOnClickListener {
            showDataFromFile()
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
        // Verificar que los campos no estén vacíos
        if (username.isEmpty() || password.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || bloodGroup.isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        // Crear el contenido a guardar
        val data = "Username: $username\nPassword: $password\nEmail: $email\nPhone Number: $phoneNumber\nBlood Group: $bloodGroup\n\n"

        // Guardar los datos en un archivo de texto
        val fileName = "asistentes.txt"
        try {
            val fileOutputStream: FileOutputStream = openFileOutput(fileName, MODE_APPEND)
            fileOutputStream.write(data.toByteArray())
            fileOutputStream.close()
            Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show()
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(this, "Error al guardar los datos", Toast.LENGTH_SHORT).show()
        }
    }
    private fun showDataFromFile() {
        val fileName = "asistentes.txt"
        val file = File(filesDir, fileName)

        if (file.exists()) {
            try {
                val data = file.readText()
                Log.d("MainActivity", "Datos almacenados:\n$data")
                Toast.makeText(this, "Datos mostrados en Logcat", Toast.LENGTH_SHORT).show()
            } catch (e: IOException) {
                e.printStackTrace()
                Toast.makeText(this, "Error al leer los datos", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "No hay datos almacenados", Toast.LENGTH_SHORT).show()
        }
    }
}