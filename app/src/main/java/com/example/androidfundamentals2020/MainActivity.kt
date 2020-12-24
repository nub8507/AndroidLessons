package com.example.androidfundamentals2020

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfundamentals2020.data.Movie
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

    override fun onMoviesListMovieClicked(movieData: Movie) {
        supportFragmentManager.beginTransaction()
            .apply {
                add(R.id.main_frame_layout, MovieDetailsFragment.newInstance(movieData))
                addToBackStack(null)
                commit()
            }
    }

}