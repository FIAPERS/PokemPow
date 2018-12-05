package br.com.albertlopes.pokempow.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.albertlopes.pokempow.R

import br.com.albertlopes.pokempow.model.Pontuacao
import kotlinx.android.synthetic.main.pontuacao_item.view.*

class RankingListAdapter(
        val context: Context,
        val pontuacoes: List<Pontuacao>,
        val listener: (Pontuacao) -> Unit) : RecyclerView.Adapter<RankingListAdapter.PontuacaoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PontuacaoViewHolder {
        val itemView = LayoutInflater.from(context)
                .inflate(R.layout.pontuacao_item, parent, false)
        return PontuacaoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PontuacaoViewHolder, position: Int) {
        val nota = pontuacoes[position]
        holder?.let {
            holder.bindView(nota, listener)
        }
    }

    override fun getItemCount(): Int {
        return pontuacoes.size
    }

    class PontuacaoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(pontuacao: Pontuacao,
                     listener: (Pontuacao) -> Unit
                     ) = with(itemView) {
            tvTitulo.text = pontuacao.nome
            tvDescricao.text = pontuacao.pontos


            setOnClickListener { listener(pontuacao) }
        }
    }
}