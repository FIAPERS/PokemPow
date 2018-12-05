package br.com.albertlopes.pokempow.view

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.Toast
import br.com.albertlopes.pokempow.R
import kotlinx.android.synthetic.main.activity_game_play.*

class GamePlayActivity : AppCompatActivity() {


    var vidasp1 = 3;
    var vidasp2 = 3;

    val vidas3 = "♥ ♥ ♥"
    val vidas2 = "♥ ♥"
    val vidas1 = "♥"

    val bullbsaurPower = "EARTH";
    val charmanderPower = "FIRE";
    val squirtlePower = "WATER";


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_play)

        resetGame()

        img_bulbassaur.setOnClickListener {
            luta(bullbsaurPower)
            img_p1.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.p1_bulbasaur))
        }

        img_charmander.setOnClickListener {
            luta(charmanderPower)
            img_p1.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.p1_charmander))
        }

        img_squirtle.setOnClickListener {
            luta(squirtlePower)
            img_p1.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.p1_squirtle))
        }

    }

    private fun resetGame(){

        txt_qtdlifesp1.text = vidas3
        txt_qtdlifesp2.text = vidas3

        img_p2.setColorFilter(null);
        img_p1.setColorFilter(null);

        img_p2.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.who))
        img_p1.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.who))

    }

    private fun luta(p1:String){

        val list = listOf<String>(bullbsaurPower,charmanderPower,squirtlePower)
        val p2 = list.shuffled().take(1)[0]

        if(p2.equals(bullbsaurPower)){
            img_p2.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.p2_bulbasaur))
        }else if(p2.equals(charmanderPower)){
            img_p2.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.p2_charmander))
        }else{
            img_p2.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.p2_squirtle))
        }

        img_p2.setColorFilter(null);
        img_p1.setColorFilter(null);


        if (p1.equals(p2)){


        } else if (p1.equals(bullbsaurPower) && p2.equals(squirtlePower) ){
            img_p2.setColorFilter(ContextCompat.getColor(this, R.color.red), android.graphics.PorterDuff.Mode.MULTIPLY);
            vidasp2--
        } else if (p1.equals(squirtlePower) && p2.equals(charmanderPower) ){
            img_p2.setColorFilter(ContextCompat.getColor(this, R.color.red), android.graphics.PorterDuff.Mode.MULTIPLY);
            vidasp2--
        } else if (p1.equals(charmanderPower) && p2.equals(bullbsaurPower) ){
            img_p2.setColorFilter(ContextCompat.getColor(this, R.color.red), android.graphics.PorterDuff.Mode.MULTIPLY);
            vidasp2--
        } else {
            img_p1.setColorFilter(ContextCompat.getColor(this, R.color.red), android.graphics.PorterDuff.Mode.MULTIPLY);
            vidasp1--
        }
        

        if(vidasp1 == 0){

            intent =  Intent(this,GameOverActivity::class.java)
            startActivity(intent)

        } else  if(vidasp2 == 0){

            Toast.makeText(this,"PARABÉNS, GANHOUUU... MÁ OI",Toast.LENGTH_LONG).show()
            resetGame()

        } else {

            if(vidasp2 == 3) txt_qtdlifesp2.text = vidas3
            if(vidasp2 == 2) txt_qtdlifesp2.text = vidas2
            if(vidasp2 == 1) txt_qtdlifesp2.text = vidas1

            if(vidasp1 == 3) txt_qtdlifesp1.text = vidas3
            if(vidasp1 == 2) txt_qtdlifesp1.text = vidas2
            if(vidasp1 == 1) txt_qtdlifesp1.text = vidas1

        }


    }

    private fun selectP1(){

    }



}
