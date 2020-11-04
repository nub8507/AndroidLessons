package com.example.lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lesson2.databinding.SecondActivityBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: SecondActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.second_activity)
        binding = SecondActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.firstTextView.setOnClickListener {
            binding.textView2.text=binding.firstTextView.text
        }
    }
}