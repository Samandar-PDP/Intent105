package com.sdk.intents

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity

class SecondActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        supportActionBar?.hide()
        window.statusBarColor = Color.parseColor("#ffffff")

        object : CountDownTimer(2000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}

            override fun onFinish() {
                val intent = Intent(this@SecondActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.start()
    }
}