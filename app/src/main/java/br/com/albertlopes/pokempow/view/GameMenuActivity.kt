package br.com.albertlopes.pokempow.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.albertlopes.pokempow.R
import kotlinx.android.synthetic.main.activity_game_menu.*

class GameMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_menu)


        btJogar.setOnClickListener{
            intent = Intent(this, GamePlayActivity::class.java)
            startActivity(intent)
        }

        btRanking.setOnClickListener{
            intent = Intent(this, RankingActivity::class.java)
            startActivity(intent)
        }

        btSobre.setOnClickListener{
            intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

        btSair.setOnClickListener{
            finish()
        }



    }


}
