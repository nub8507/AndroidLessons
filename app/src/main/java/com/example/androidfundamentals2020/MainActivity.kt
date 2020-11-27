package com.example.androidfundamentals2020

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfundamentals2020.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),FragmentMoviesDetails.OnMoviesDetailsListener,FragmentMoviesList.OnMoviesListListener  {

    private lateinit var binding: ActivityMainBinding
    private var movieId: Int = 0

    private val rootFragment =
            FragmentMoviesList().apply {
                setClickListener(this@MainActivity)
            }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .apply {
                add(R.id.main_frame_layout, rootFragment)
                commit()
            }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(MOVIE_ID_TAG, movieId)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        movieId = savedInstanceState.getInt(MOVIE_ID_TAG)
        if (movieId!=0)
            onMoviesListMovieClicked()
    }

    override fun onMoviesDetailsButtonBackClicked() {
        onBackPressed()
        movieId = 0
    }

    override fun onMoviesListMovieClicked() {
        val movieFragment=FragmentMoviesDetails()
        supportFragmentManager.beginTransaction()
            .apply {
                add(R.id.main_frame_layout, movieFragment)
                movieId = 1
                addToBackStack(null)
                commit()
            }

    }

    companion object {
        private const val MOVIE_ID_TAG = "MOVIE_ID_TAG"

    }
}