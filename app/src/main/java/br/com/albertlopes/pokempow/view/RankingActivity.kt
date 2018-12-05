package br.com.albertlopes.pokempow.view

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import br.com.albertlopes.pokempow.R
import br.com.albertlopes.pokempow.model.Pontuacao

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_ranking.*

//import kotlinx.android.synthetic.main.content_main.*
//import kotlinx.android.synthetic.main.loading.*

class RankingActivity : AppCompatActivity() {

    lateinit var rankingViewModel: RankingViewModel
    private var adapter: RankingListAdapter? = null


    val FORMULARIO_REQUEST_CODE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        rankingViewModel = ViewModelProviders.of(this)
                .get(RankingViewModel::class.java)


        rankingViewModel.pontuacoes.observe(this, notasObserver)
        //rankingViewModel.isLoading.observe(this, loadingObserver)

        rankingViewModel.buscarTodos()

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            FORMULARIO_REQUEST_CODE -> {


                when (resultCode) {
                    Activity.RESULT_OK -> {
                        rankingViewModel.buscarTodos()
                    }
                    Activity.RESULT_CANCELED -> {
                        Toast.makeText(this, "Cancelou", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }

    }



    private var notasObserver = Observer<List<Pontuacao>> {
        preencheALista(it!!)
    }

    /*private var loadingObserver = Observer<Boolean> {
        if (it == true) {
            containerLoading.visibility = View.VISIBLE
        } else {
            containerLoading.visibility = View.INVISIBLE
        }
    }*/

    private fun preencheALista(pontuacoes: List<Pontuacao>) {
        adapter = RankingListAdapter(this, pontuacoes, {})

        rvPontuacoes.adapter = adapter
        rvPontuacoes.layoutManager = LinearLayoutManager(this)
    }




}
