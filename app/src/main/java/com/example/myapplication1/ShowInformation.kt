package com.example.myapplication1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.myapplication1.fragment.Information
import com.example.myapplication1.fragment.Utils

class ShowInformation : AppCompatActivity() {

    private lateinit var  edtNombre : TextView
    private lateinit var btnRegresar :Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_information)

        edtNombre = findViewById(R.id.txtNombre)
        btnRegresar = findViewById(R.id.btnRegresar)

        edtNombre.text = "Bienvenido \n" + Utils.Variable.NombreLogin
        btnRegresar.setOnClickListener {
            //val intent = Intent(this@ShowInformation, MainActivity::class.java)
            //startActivity(intent)
            val fragment = Information()
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,  fragment).commit()
            btnRegresar.visibility = View.GONE
        }
    }
}