package com.anushka.retrofitdemo.Ejercicios


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class EjerciciosItem(

    @SerializedName("idEjercicio")
    @Expose
    val idEjercicio: Int,

    @SerializedName("nombre")
    @Expose
    val nombre: String,

    @SerializedName("duracion")
    @Expose
    val duracion: Int,

    @SerializedName("series")
    @Expose
    val series: Int,

    @SerializedName("repeticiones")
    @Expose
    val repeticiones: Int,

    @SerializedName("imagen")
    @Expose
    val imagen: String,

    @SerializedName("descripcion")
    @Expose
    val descripcion: String,

    @SerializedName("descanso")
    @Expose
    val descanso: Int
)