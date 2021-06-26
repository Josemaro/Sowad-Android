package com.anushka.retrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.anushka.retrofitdemo.Ejercicios.EjercicioService
import com.anushka.retrofitdemo.Ejercicios.Ejercicios
import com.anushka.retrofitdemo.Ejercicios.EjerciciosItem
import com.anushka.retrofitdemo.Ejercicios.RetrofitInstance
import com.anushka.retrofitdemo.Usuarios.UsuarioService
import com.anushka.retrofitdemo.Usuarios.UsuariosItem
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response

class MainActivity : AppCompatActivity() {
  private lateinit var retService: EjercicioService
    private lateinit var retService2: UsuarioService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        retService = RetrofitInstance
            .getRetrofitInstance()
            .create(EjercicioService::class.java)
        retService2 = RetrofitInstance
            .getRetrofitInstance()
            .create(UsuarioService::class.java)
        getRequestWithQueryParameters()
        getRequestWithPathParameters()
        //uploadEjercicio()
        uploadUsuario()
        //getRequestWithPathParameters2()
    }


    private fun getRequestWithQueryParameters() {
        val responseLiveData: LiveData<Response<Ejercicios>> = liveData {
            val response = retService.getEjercicios()
            emit(response)
        }
        responseLiveData.observe(this, Observer {
            val ejerciciosList = it.body()?.listIterator()
            if (ejerciciosList != null) {
                while (ejerciciosList.hasNext()) {
                    val ejerciciosItem = ejerciciosList.next()
                    val result = " " + "Ejercicio : ${ejerciciosItem.nombre}" + "\n" +
                            " " + "Duracion : ${ejerciciosItem.duracion}" + "\n" +
                            " " + "Series : ${ejerciciosItem.series}" + "\n\n\n"
                    text_view.append(result)
                }
            }
        })
    }


    private fun getRequestWithPathParameters() {
        val pathResponse: LiveData<Response<EjerciciosItem>> = liveData {
            val response = retService.getEjercicio(2)
            emit(response)
        }

        pathResponse.observe(this, Observer {
            val title = it.body()?.nombre
            Toast.makeText(applicationContext, title, Toast.LENGTH_LONG).show()
        })
    }

    private fun uploadEjercicio() {
        val ejercicio = EjerciciosItem(0,"PRUEBA SOWAD",3,3,3,"","HolaMundo",5);
        val postResponse: LiveData<Response<EjerciciosItem>> = liveData {
            val response = retService.uploadAlbum(ejercicio)
            emit(response)
        }
        postResponse.observe(this, Observer {
            val receivedEjerciciosItem = it.body()
            val result = " " + "Nombre: ${receivedEjerciciosItem?.nombre}" + "\n" +
                    " " + " : ${receivedEjerciciosItem?.duracion}" + "\n" +
                    " " + "User id : ${receivedEjerciciosItem?.series}" + "\n\n\n"
            text_view.text = result
        })

    }


    private fun getRequestWithPathParameters2() {
        val pathResponse: LiveData<Response<UsuariosItem>> = liveData {
            val response = retService2.getUsuario("admin@admin.com")
            emit(response)
        }

        pathResponse.observe(this, Observer {
            val title = it.body()?.nombres
            Toast.makeText(applicationContext, title, Toast.LENGTH_LONG).show()
        })
    }

    private fun uploadUsuario() {
        val usuario = UsuariosItem(null,"SABADO","SABADO","SABADO");
        val postResponse: LiveData<Response<UsuariosItem>> = liveData {
            val response = retService2.uploadUsuario(usuario)
            emit(response)
        }
        postResponse.observe(this, Observer {
            val receivedUsuariosItem = it.body()
            val result = " " + "Nombre: ${receivedUsuariosItem?.nombres}" + "\n" +
                    " " + "Apellidos : ${receivedUsuariosItem?.apellidos}" + "\n" +
                    " " + "User id : ${receivedUsuariosItem?.idUsuario}" + "\n\n\n"
            text_view.text = result
        })

    }


}
