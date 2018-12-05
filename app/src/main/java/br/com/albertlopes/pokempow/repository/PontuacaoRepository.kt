package br.com.albertlopes.pokempow.repository

import br.com.albertlopes.pokempow.api.getJokenPokemonAPI
import br.com.albertlopes.pokempow.model.Pontuacao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PontuacaoRepository {

    fun buscarTodos(
            onComplete: (List<Pontuacao>?) -> Unit,
            onError: (Throwable?) -> Unit
    ) {
        getJokenPokemonAPI()
                .buscarTodos()
                .enqueue(object : Callback<List<Pontuacao>>{
                    override fun onFailure(call: Call<List<Pontuacao>>?, t: Throwable?) {
                        onError(t)
                    }

                    override fun onResponse(call: Call<List<Pontuacao>>?, response: Response<List<Pontuacao>>?) {
                        onComplete(response?.body())
                    }
                })
    }

    fun salvar(pontuacao: Pontuacao,
               onComplete: (Pontuacao?) -> Unit,
               onError: (Throwable?) -> Unit) {

        getJokenPokemonAPI()
                .salvar(pontuacao)
                .enqueue(object : Callback<Pontuacao>{
                    override fun onFailure(call: Call<Pontuacao>?, t: Throwable?) {
                        onError(t)
                    }

                    override fun onResponse(call: Call<Pontuacao>?, response: Response<Pontuacao>?) {
                        onComplete(response?.body())
                    }

                })
    }

}