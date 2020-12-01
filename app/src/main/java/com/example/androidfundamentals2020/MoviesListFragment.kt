package com.example.androidfundamentals2020

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfundamentals2020.databinding.MoviesListFragmentBinding

class MoviesListFragment : Fragment() {

    private var binding: MoviesListFragmentBinding? = null
    private var openMovieDetailsListener: OnMoviesListListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is OnMoviesListListener) {
            openMovieDetailsListener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val movieListRecyclerView = container?.findViewById<View>(R.id.movie_list_recycler_view) as RecyclerView
        val movies = MovieListData.getMoviesListData()
        movieListRecyclerView.adapter = MovieListAdapter(movies)
        val view = inflater.inflate(R.layout.movies_list_fragment, container, false)
        movieListRecyclerView.layoutManager = GridLayoutManager(container.context,2)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MoviesListFragmentBinding.bind(view)
//        binding!!.btnMovieSelect.setOnClickListener { openMovieDetailsListener?.onMoviesListMovieClicked() }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    override fun onDetach() {
        openMovieDetailsListener = null
        super.onDetach()
    }

    interface OnMoviesListListener {
        fun onMoviesListMovieClicked()
    }

    companion object {
        fun newInstance(): MoviesListFragment {
            return MoviesListFragment()
        }
    }
}