package com.sdk.intents

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.os.bundleOf
import com.sdk.intents.model.Footballer
import com.sdk.intents.model.User

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val btn: Button = findViewById(R.id.btn)
        val etName: EditText = findViewById(R.id.name)
        val etLastName: EditText = findViewById(R.id.lastName)
        val etAge: EditText = findViewById(R.id.age)
        val footballer = intent.getParcelableExtra("footballer") as? Footballer
        Log.d("@@@", "onCreate: $footballer")
        btn.setOnClickListener {
            val intent = Intent()
            val name = etName.text.toString().trim()
            val lastName = etLastName.text.toString().trim()
            val age = etAge.text.toString().trim().toInt()
            val bundle = bundleOf("secondUser" to User(name, lastName, age))
            intent.putExtras(bundle)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}