package com.example.myapplication1

class User (nombreUsuario: String, password: String) {

    var nombreUsuario = nombreUsuario
    var password = password

    fun iniciarSesion() : Boolean{
        var response = false
        if (nombreUsuario.equals("Carmen")  &&  password.equals("04082023")){
            response = true
        }else{
            response = false
        }
        return response
    }

}