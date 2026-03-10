package com.example.androidproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.app.Activity

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        val editText = findViewById<EditText>(R.id.editTextText)
        val btnOpenSecond = findViewById<Button>(R.id.button)
        val btnCall = findViewById<Button>(R.id.button2)
        val btnShare = findViewById<Button>(R.id.button3)

        btnOpenSecond.setOnClickListener {
            val text = editText.text.toString()
            if (text.isNotEmpty()) {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("EXTRA_TEXT", text)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Введите текст", Toast.LENGTH_SHORT).show()
            }
        }

        btnCall.setOnClickListener {
            val phoneNumber = editText.text.toString()
            if (phoneNumber.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:$phoneNumber")
                startActivity(intent)
            } else {
                Toast.makeText(this, "Введите номер", Toast.LENGTH_SHORT).show()
            }
        }

        btnShare.setOnClickListener {
            val text = editText.text.toString()

            if (text.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, text)

                val chooser = Intent.createChooser(intent, "Поделиться через...")
                startActivity(chooser)
            } else {
                Toast.makeText(this, "Введите текст", Toast.LENGTH_SHORT).show()
            }
        }
    }
}