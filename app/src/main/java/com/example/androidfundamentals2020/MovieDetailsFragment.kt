package com.example.androidfundamentals2020

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.androidfundamentals2020.data.Movie
import com.example.androidfundamentals2020.databinding.MoviesDetailsFragmentBinding

class MovieDetailsFragment() : Fragment() {

    private var binding: MoviesDetailsFragmentBinding? = null

    private val viewModel: MovieDetailsViewModel by viewModels {
        MovieDetailsViewModelFactory(MovieListInteractor(requireContext()))
    }

    private var selectedMovieID: Int = 0

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
        viewFill(
            Movie(
                id = 0,
                title = "",
                overview = "",
                poster = "",
                backdrop = "",
                ratings = 0f,
                numberOfRatings = 0,
                minimumAge = 0,
                runtime = 0,
                genres = listOf(),
                actors = listOf()
            )
        )
        viewModel.selectedMovieList.observe(
            this.viewLifecycleOwner,
            Observer { viewModel.getMovie() })
        if (savedInstanceState == null) {
            viewModel.setMovie(selectedMovieID)
        }
        viewModel.movie.observe(this.viewLifecycleOwner, this::viewFill)
    }

    private fun viewFill(movie: Movie) {
        movie.apply {
            binding!!.backgroundImageView.load(backdrop)
            binding!!.pgTextView.text = "$minimumAge+"
            binding!!.nameTextView.text = title
            var tagMovie: String = ""
            genres.forEach { tagMovie += it.name + "," }
            binding!!.tagTextView.text = tagMovie
            binding!!.starRatingbar.rating = ratings / 2
            binding!!.ratingTextView.text = "$numberOfRatings Reviews"
            binding!!.storylineTextView.text = overview

            val actorListRecyclerView = binding!!.movieDetailActorRecyclerView
            val actorListEmptyText = binding!!.emptyRecyclerTextView
            actorListRecyclerView.adapter = MovieDetailsActorAdapter(actors)
            actorListRecyclerView.layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
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
        fun newInstance(movieID: Int): MovieDetailsFragment {
            val movieFragment = MovieDetailsFragment()
            movieFragment.selectedMovieID = movieID
            return movieFragment
        }
    }

}