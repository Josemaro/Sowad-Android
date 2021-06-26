package com.anushka.retrofitdemo.Usuarios

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface UsuarioService {

    @GET("/usuario/{email}")
    suspend fun getUsuario(@Path(value ="email") email: String): Response<UsuariosItem>

    @POST("/auth/create")
    suspend fun uploadUsuario(@Body usuario: UsuariosItem): Response<UsuariosItem>

    @POST("/auth/login")
    suspend fun loginUsuario(@Body usuario: UsuariosItem): Response<UsuariosItem>

}
