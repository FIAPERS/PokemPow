package br.com.albertlopes.pokempow.api

import retrofit2.Call
import retrofit2.http.*

import br.com.albertlopes.pokempow.model.Pontuacao


interface NotaAPI {

    @GET("/pontuacao")
    fun buscarTodos(): Call<List<Pontuacao>>


    @POST("/pontuacao")
    fun salvar(@Body pontuacao: Pontuacao): Call<Pontuacao>

}