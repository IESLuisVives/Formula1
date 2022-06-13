package com.example.formula1tfcfront.aplication.rest;


import com.example.formula1tfcfront.aplication.rest.model.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.UUID;

public interface Api {


    @GET("/noticia/all")
    Call<List<Noticia>> obtenerNoticias();

    @GET("/piloto/all")
    Call<List<Piloto>> obtenerPilotos();

    @GET("/circuito/all")
    Call<List<Circuito>> obtenerCircuitos();

    @GET("/clasificacion/all")
    Call<List<ClasificacionPiloto>> obtenerClasificacionPilotos();

    @GET("/clasificacion/all/escuderias")
    Call<List<ClasificacionEscuderia>> obtenerClasificacionEscuderia();

    @POST("/usuario/save")
    Call<Usuario> crearUsuario(@Body Usuario usuario);

    @POST("/usuario/login")
    Call<Usuario> login(@Body LoginEntity login);

}
