package com.anushka.retrofitdemo.Usuarios


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UsuariosItem(

    @SerializedName("id_usuario")
    @Expose
    val idUsuario: Int?,


    @SerializedName("nombres")
    @Expose
    val nombres: String,

    @SerializedName("apellidos")
    @Expose
    val apellidos: String,

    @SerializedName("correo")
    @Expose
    val correo: String
/*
    @SerializedName("contra")
    @Expose
    val contra: String,

    @SerializedName("altura")
    @Expose
    val altura: Float,

    @SerializedName("peso")
    @Expose
    val peso: Float,

    @SerializedName("imagen")
    @Expose
    val imagen: String
*/

)