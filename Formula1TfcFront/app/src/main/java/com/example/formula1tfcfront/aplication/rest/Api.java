package com.example.formula1tfcfront.aplication.rest;


import com.example.formula1tfcfront.aplication.rest.model.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.UUID;

public interface Api {
    @GET("/cliente/login")
    Call<Usuario> loginWithToken(@Query(value="token") UUID token,
                                 @Query(value="mail")String mail,
                                 @Query(value="password")String password);

    @GET("/cliente/login")
    Call<Usuario> loginWithoutToken(@Query(value="mail")String mail,
                                    @Query(value="password")String password);

    @GET("/piloto/all")
    Call<List<Piloto>> obtenerTodosPilotos();

    @GET("/circuito/all")
    Call<List<Circuito>> obtenerTodosCircuitos();

    @GET("/noticia/all")
    Call<List<Noticia>> obtenerNoticias();

    @GET("/piloto/all")
    Call<List<Piloto>> obtenerPilotos();

    @GET("/circuito/all")
    Call<List<Circuito>> obtenerCircuitos();

    @GET("/clasificacion/all")
    Call<List<ClasificacionPiloto>> obtenerClasificacionPilotos();

    @POST("/cliente/post")
    Call<Usuario> crearUsuario(@Body Usuario usuario);

    @PUT("/cliente/put")
    Call<Usuario> reservaUsuario(@Body Usuario usuario);




}
