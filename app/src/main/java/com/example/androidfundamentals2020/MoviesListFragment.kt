package com.example.androidfundamentals2020

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfundamentals2020.data.Movie
import com.example.androidfundamentals2020.data.loadMovies
import com.example.androidfundamentals2020.databinding.MoviesListFragmentBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MoviesListFragment : Fragment() {

    private var binding: MoviesListFragmentBinding? = null
    private var openMovieDetailsListener: OnMoviesListListener? = null

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
        val movieListRecyclerView = view.findViewById<RecyclerView>(R.id.movie_list_recycler_view)
        val movieListEmpty = view.findViewById<TextView>(R.id.empty_recycler_text_view)
        var movies: List<Movie> = listOf()
        CoroutineScope(Dispatchers.Default).launch {
            setMovieListVisible(movies, movieListRecyclerView, movieListEmpty, view)
        }
        CoroutineScope(Dispatchers.IO).launch {
            movies = loadMovies(requireContext())
            setMovieListVisible(movies, movieListRecyclerView, movieListEmpty, view)
        }
    }

    private suspend fun setMovieListVisible(
        movies: List<Movie>,
        movieListRecyclerView: RecyclerView,
        movieListEmpty: TextView,
        view: View
    ) = withContext(Dispatchers.Main) {
        if (movies.isNotEmpty()) {
            movieListRecyclerView.visibility = View.VISIBLE
            movieListEmpty.visibility = View.GONE
            movieListRecyclerView.adapter = MovieListAdapter(movies, movieOnClick)
            movieListRecyclerView.layoutManager = GridLayoutManager(view.context, 2)
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
        fun onMoviesListMovieClicked(movieData: Movie)
    }

    private val movieOnClick = object : MovieListAdapter.OnRecyclerItemClicked {
        override fun onClick(movieData: Movie) {
            openMovieDetailsListener?.onMoviesListMovieClicked(movieData)
        }
    }

    companion object {
        fun newInstance(): MoviesListFragment {
            return MoviesListFragment()
        }
    }
}