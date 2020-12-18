package com.example.androidfundamentals2020

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.androidfundamentals2020.data.Movie
import com.example.androidfundamentals2020.databinding.MoviesDetailsFragmentBinding

class MovieDetailsFragment(private val movie: Movie) : Fragment() {

    private var binding: MoviesDetailsFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movies_details_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MoviesDetailsFragmentBinding.bind(view)
        binding!!.buttonBack.setOnClickListener { activity?.onBackPressed() }

        viewFill(view, binding!!)
    }

    private fun viewFill(view: View, binding: MoviesDetailsFragmentBinding) {
        movie.apply {
            binding.backgroundImageView.load(backdrop)
            binding.pgTextView.text = "$minimumAge+"
            binding.nameTextView.text = title
            var tagMovie: String = ""
            genres.forEach { tagMovie += it.name + "," }
            binding.tagTextView.text = tagMovie
            binding.starRatingbar.rating = ratings / 2
            binding.ratingTextView.text = "$numberOfRatings Reviews"
            binding.storylineTextView.text = overview

            val actorListRecyclerView = binding.movieDetailActorRecyclerView
            val actorListEmptyText = binding.emptyRecyclerTextView
            actorListRecyclerView.adapter = MovieDetailsActorAdapter(actors)
            actorListRecyclerView.layoutManager =
                LinearLayoutManager(view.context, RecyclerView.HORIZONTAL, false)
            if (actors.isNotEmpty()) {
                actorListRecyclerView.visibility = View.VISIBLE
                actorListEmptyText.visibility = View.GONE
            } else {
                actorListRecyclerView.visibility = View.INVISIBLE
                actorListEmptyText.visibility = View.VISIBLE
            }
        }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    companion object {
        fun newInstance(movieData: Movie): MovieDetailsFragment {
            return MovieDetailsFragment(movieData)
        }
    }

}