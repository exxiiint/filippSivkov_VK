package com.example.androidproject

import android.os.Bundle
import android.widget.TextView
import android.app.Activity

class SecondActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val textView: TextView = findViewById(R.id.textViewDisplay)
        val receivedText = intent.getStringExtra("EXTRA_TEXT")
        textView.text = "Получено: $receivedText"
    }
}