package com.example.androidfundamentals2020

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfundamentals2020.data.Movie
import com.example.androidfundamentals2020.databinding.MoviesListFragmentBinding

class MoviesListFragment : Fragment() {

    private var binding: MoviesListFragmentBinding? = null
    private var openMovieDetailsListener: OnMoviesListListener? = null

    private val viewModel: MovieListViewModel by viewModels {
        MovieListViewModelFactory(MovieListInteractor(requireContext()))
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnMoviesListListener) {
            openMovieDetailsListener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movies_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MoviesListFragmentBinding.bind(view)
        val movieListRecyclerView = binding!!.movieListRecyclerView
        val movieListEmpty = binding!!.emptyRecyclerTextView
        var movies: List<Movie> = listOf()
        setMovieListVisible(movies, movieListRecyclerView, movieListEmpty)
        viewModel.moviesList.observe(this.viewLifecycleOwner, this::updateMovieList)
    }

    fun updateMovieList(movies: List<Movie>) {
        val movieListRecyclerView = binding!!.movieListRecyclerView
        val movieListEmpty = binding!!.emptyRecyclerTextView
        setMovieListVisible(movies, movieListRecyclerView, movieListEmpty)
    }


    private fun setMovieListVisible(
        movies: List<Movie>,
        movieListRecyclerView: RecyclerView,
        movieListEmpty: TextView
    ) {
        if (movies.isNotEmpty()) {
            movieListRecyclerView.visibility = View.VISIBLE
            movieListEmpty.visibility = View.GONE
            movieListRecyclerView.adapter = MovieListAdapter(movies, movieOnClick)
            movieListRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        } else {
            movieListRecyclerView.visibility = View.INVISIBLE
            movieListEmpty.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onDetach() {
        openMovieDetailsListener = null
        super.onDetach()
    }

    interface OnMoviesListListener {
        fun onMoviesListMovieClicked(movieID: Int)
    }

    private val movieOnClick = object : MovieListAdapter.OnRecyclerItemClicked {
        override fun onClick(movieData: Movie) {
            openMovieDetailsListener?.onMoviesListMovieClicked(movieData.id)
        }
    }

    companion object {
        fun newInstance(): MoviesListFragment {
            return MoviesListFragment()
        }
    }
}