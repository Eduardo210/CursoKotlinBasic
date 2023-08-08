package com.example.myapplication1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ShowInformation : AppCompatActivity() {

    private lateinit var  edtNombre : TextView
    private lateinit var btnRegresar :Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_information)

        var nombreUsuario = intent.getStringExtra("nombre")
           // intent.extras!!.getString("nombre")

        edtNombre = findViewById(R.id.txtNombre)
        btnRegresar = findViewById(R.id.btnRegresar)

        edtNombre.setText(nombreUsuario)
        btnRegresar.setOnClickListener {
            val intent = Intent(this@ShowInformation, MainActivity::class.java)
            startActivity(intent)
        }
    }
}