package com.example.testtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var button : Button
    lateinit var textVieww: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        var bruh = 0
        var sheesh = 0
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        textVieww = findViewById(R.id.textView)
        button.setOnClickListener {
            when(bruh){
                0 -> sheesh += 1
            }
            textVieww.text = sheesh.toString()
        }
    }
}