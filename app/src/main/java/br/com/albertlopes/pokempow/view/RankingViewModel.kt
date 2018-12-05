package br.com.albertlopes.pokempow.view

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.albertlopes.pokempow.model.Pontuacao
import br.com.albertlopes.pokempow.repository.PontuacaoRepository

class RankingViewModel : ViewModel() {

    val pontuacaoRepository = PontuacaoRepository()

    var pontuacoes: MutableLiveData<List<Pontuacao>> = MutableLiveData()
    var isLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun buscarTodos() {
        isLoading.value = true
        pontuacaoRepository
                .buscarTodos(
                        onComplete = {
                            isLoading.value = false
                            pontuacoes.value = it

                        }, onError = {
                    isLoading.value = false
                    pontuacoes.value = arrayListOf()
                })
    }

}