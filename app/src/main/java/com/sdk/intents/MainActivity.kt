package com.sdk.intents

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf
import com.google.android.material.button.MaterialButton
import com.sdk.intents.model.Footballer
import com.sdk.intents.model.User

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.text)
        val btn: Button = findViewById(R.id.btn)
        val etName: EditText = findViewById(R.id.name)
        val etLastName: EditText = findViewById(R.id.lastName)
        val etAge: EditText = findViewById(R.id.age)
        btn.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            val name = etName.text.toString().trim()
            val lastName = etLastName.text.toString().trim()
            val age = etAge.text.toString().trim()
           // val bundle = bundleOf("user" to User(name, lastName, age))
            val footballer = bundleOf("footballer" to Footballer("Kane",10, "Tottenham"))
            intent.putExtras(footballer)
            resultLauncher.launch(intent)
        }
    }

    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK && it.data != null) {
                //val language = it.data?.getStringExtra("language") + it.data?.getIntExtra("year", 0)
                val user = it.data?.getSerializableExtra("secondUser") as User
                textView.text = "${user.name}${user.lastName}${user.age}"
            }
        }
}