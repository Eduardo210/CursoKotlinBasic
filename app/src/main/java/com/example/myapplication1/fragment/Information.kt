package com.example.myapplication1.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication1.R


class Information : Fragment() {
     private lateinit var edtNombre : EditText
    private lateinit var edtCorreo : EditText
    private lateinit var edtTelefono : EditText
    private lateinit var edtPassword : EditText
    private lateinit var btnGuardar : Button
    private lateinit var btnConsultar : Button
    private lateinit var btnBorrarDato : Button
    private lateinit var btnBorrarArchivo : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_information, container, false)

        edtNombre = view.findViewById(R.id.edtCliente)!!
        edtCorreo = view.findViewById(R.id.edtCorreo)!!
        edtTelefono = view.findViewById(R.id.edtTelefono)!!
        edtPassword = view.findViewById<EditText>(R.id.edtPasswordInformation)
        //btnGuardar = view?.findViewById(R.id.btnGuardar)!!

        btnGuardar = view.findViewById(R.id.btnGuardar)
        btnConsultar = view.findViewById(R.id.btnConsulta)

        btnBorrarArchivo = view.findViewById(R.id.btnDelete)
        btnBorrarDato = view.findViewById(R.id.btnDeleteData)

        btnGuardar.setOnClickListener {
            if (edtNombre.text.toString().isBlank() && edtCorreo.text.toString().isBlank() && edtTelefono.text.toString().isBlank() && edtPassword.text.toString().isBlank()){
                Toast.makeText(requireActivity(), "Alguno de los campos estan vacios", Toast.LENGTH_SHORT).show()
            }else{
                val sharedPreferences = requireActivity().getSharedPreferences("data_user",Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("Usuario", edtNombre.text.toString())
                editor.putString("Correo", edtCorreo.text.toString())
                editor.putString("Telefono", edtTelefono.text.toString())
                editor.putString("Password", edtPassword.text.toString())
                editor.apply()

                val valorGuardado = sharedPreferences?.getString("Usuario",null)
                if (valorGuardado.equals(edtNombre.text.toString())){
                    Toast.makeText(requireActivity(), "El los datos se guardaron correctamente", Toast.LENGTH_SHORT).show()
                    edtNombre.setText("")
                    edtCorreo.setText("")
                    edtTelefono.setText("")
                    edtPassword.setText("")
                }else{
                    Toast.makeText(requireActivity(), "Los datos no se guardaron", Toast.LENGTH_SHORT).show()
                }
            }
        }

        btnConsultar.setOnClickListener {
            val sharedPreferences = requireActivity().getSharedPreferences("data_user",Context.MODE_PRIVATE)
            val nombreUsuario = sharedPreferences?.getString("Usuario",null)
            val email = sharedPreferences?.getString("Correo",null)
            val phone = sharedPreferences?.getString("Telefono",null)
            val pass = sharedPreferences?.getString("Password",null)

            edtNombre.setText(nombreUsuario)
            edtCorreo.setText(email)
            edtTelefono.setText(phone)
            edtPassword.setText(pass)

        }

        btnBorrarDato.setOnClickListener {
            val sharedPreferences = requireActivity().getSharedPreferences("data_user",Context.MODE_PRIVATE)
            val editor = sharedPreferences?.edit()
            editor?.remove("Password")
            editor?.apply()
        }

        btnBorrarArchivo.setOnClickListener {
            val sharedPreferences = requireActivity().getSharedPreferences("data_user",Context.MODE_PRIVATE)
            val editor = sharedPreferences?.edit()
            editor?.clear()
            editor?.apply()
        }


        return view


    }


}