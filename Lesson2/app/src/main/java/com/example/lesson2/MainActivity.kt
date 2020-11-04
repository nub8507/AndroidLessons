package com.example.lesson2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        first_text_view.setOnClickListener {
            val intent = Intent( this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    fun onButtonNumClick(c_button: View) {
        first_text_view.text=(c_button as Button).text
    }


}