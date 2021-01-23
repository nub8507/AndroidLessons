package com.example.androidfundamentals2020

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidfundamentals2020.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MoviesListFragment.OnMoviesListListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .apply {
                    add(R.id.main_frame_layout, MoviesListFragment.newInstance())
                    commit()
                }
        }
    }

    override fun onMoviesListMovieClicked(movieID: Long) {
        supportFragmentManager.beginTransaction()
            .apply {
                add(R.id.main_frame_layout, MovieDetailsFragment.newInstance(movieID))
                addToBackStack(null)
                commit()
            }
    }

}