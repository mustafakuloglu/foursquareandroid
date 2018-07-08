package com.kuloglu.foursquareandroid.ui.splash

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kuloglu.foursquareandroid.R
import com.kuloglu.foursquareandroid.ui.main.MainActivity
import timber.log.Timber


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startThread()
    }

    private fun startThread() {


        Thread(Runnable {

            try {
                Thread.sleep(2000)
            } catch (e: InterruptedException) {
                Timber.e(e)
            }
            runOnUiThread {

                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
            }

        }).start()
    }
}