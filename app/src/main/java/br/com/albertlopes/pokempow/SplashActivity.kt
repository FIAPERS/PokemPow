package br.com.albertlopes.pokempow

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import br.com.albertlopes.pokempow.view.AboutActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    private val TEMPO_AGUARDO_SPLASHSCREEN = 3500L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        val preferences = getSharedPreferences("user_preferences", Context.MODE_PRIVATE)
        val isFirstOpen = preferences.getBoolean("open_first", true)

        if (isFirstOpen) {
            markAppAlreadyOpen(preferences)
            showSplashMain()
        } else {
            showLogin()
        }
    }

    private fun showSplashMain() {
        val anim = AnimationUtils.loadAnimation(this, R.anim.animacao_splash)
        anim.reset()
        ivMainLogo.clearAnimation()
        ivMainLogo.startAnimation(anim)

        Handler().postDelayed({
            //showSplashFinish()
            showLogin()
        },TEMPO_AGUARDO_SPLASHSCREEN)
    }

    private fun markAppAlreadyOpen(preferences: SharedPreferences) {
        val editor = preferences.edit()
        editor.putBoolean("open_first", false)
        editor.apply()
    }

    private fun showLogin() {
        val nextScreen = Intent (this@SplashActivity, AboutActivity::class.java)
        startActivity(nextScreen)
        finish()
    }

    /*private fun showSplashFinish() {
        val anim = AnimationUtils.loadAnimation(this,R.anim.animacao_splash)
        anim.reset()
        ivJokenLogo.clearAnimation()
        ivJokenLogo.startAnimation(anim)

        Handler().postDelayed({
            showLogin()
        },TEMPO_AGUARDO_SPLASHSCREEN)
    }*/
}
