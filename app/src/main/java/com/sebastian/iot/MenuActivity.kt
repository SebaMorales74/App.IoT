package com.sebastian.iot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val intento = intent
        val data: String? = intento.getStringExtra("datos")
        val titulo: TextView = findViewById(R.id.menu_title)
        if (data.equals("correcto")) titulo.text = "Login exitoso!"
        else titulo.text = "Credenciales no existentes :("
    }

}
