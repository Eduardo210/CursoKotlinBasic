package com.example.myapplication1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var nombreUsuario : EditText
    private lateinit var password : EditText
    private lateinit var btnIngresar : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nombreUsuario = findViewById(R.id.edtUsuario)
        password = findViewById(R.id.edtPassword)
        btnIngresar = findViewById(R.id.btnIngresar)

        btnIngresar.setOnClickListener {
            if (nombreUsuario.text.toString().isBlank()){
                Toast.makeText(this, "Ingresa el nombre de usuario", Toast.LENGTH_SHORT).show()
            }else{
                if (password.text.toString().isBlank()){
                    Toast.makeText(this@MainActivity, "Ingresa la password", Toast.LENGTH_SHORT).show()
                }else{
                    val user = User(nombreUsuario = nombreUsuario.text.toString() , password = password.text.toString())
                    var respuesta = user.iniciarSesion()
                    if (respuesta){
                        val intentIntercambio = Intent(this@MainActivity, ShowInformation::class.java)
                        intent.putExtra("nombre", "Hola mundo")
                        startActivity(intentIntercambio)
                    }else{
                        Toast.makeText(this@MainActivity, "Acceso denegado", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}