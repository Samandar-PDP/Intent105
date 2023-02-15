package com.sdk.intents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ImplicityIntent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicity_intent)


        val btn: Button = findViewById(R.id.button)
        btn.setOnClickListener {
            val call = Intent(Intent.ACTION_SEND)
            call.type = "text/plain"
            call.data = Uri.parse("smsto:+9989645454")
            call.putExtra(Intent.EXTRA_TEXT, "Hehe")
            startActivity(Intent.createChooser(call, "Share sms"))
        }
        ////            val intent = Intent(Intent.ACTION_VIEW)
        ////            intent.data = Uri.parse("https://t.me/Samandar_sdk")
        ////            startActivity(intent)
    }
}