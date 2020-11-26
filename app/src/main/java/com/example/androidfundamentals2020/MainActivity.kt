package com.example.androidfundamentals2020

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfundamentals2020.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),FragmentMoviesDetails.OnMoviesDetailsListener {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onMoviesDetailsButtonBackClicked(fragmentIndex: Int) {
        supportFragmentManager.findFragmentById(R.id.main_frame_layout)
    }
}