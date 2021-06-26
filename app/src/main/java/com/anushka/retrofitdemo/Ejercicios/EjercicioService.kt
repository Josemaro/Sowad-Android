package com.anushka.retrofitdemo.Ejercicios

import retrofit2.Response
import retrofit2.http.*


interface EjercicioService {

    @GET("/ejercicio/lista")
    suspend fun getEjercicios(): Response<Ejercicios>

    @GET("/ejercicio/lista")
    suspend fun getSortedAlbums(@Query("idUsuario") idUsuario: Int): Response<Ejercicios>

    @GET("/ejercicio/{id}")
    suspend fun getEjercicio(@Path(value = "id") idUsuario: Int): Response<EjerciciosItem>

    @POST("/ejercicio/create")
    suspend fun uploadAlbum(@Body album: EjerciciosItem): Response<EjerciciosItem>


}