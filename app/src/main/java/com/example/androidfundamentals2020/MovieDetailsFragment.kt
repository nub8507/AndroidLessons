package com.example.androidfundamentals2020

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfundamentals2020.databinding.MoviesDetailsFragmentBinding

class MovieDetailsFragment : Fragment() {

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
        binding!!.buttonBack.setOnClickListener{ activity?.onBackPressed() }

        val actorListRecyclerView = view.findViewById<View>(R.id.movie_detail_actor_recycler_view) as RecyclerView
        actorListRecyclerView.adapter = MovieDetailsActorAdapter(MovieActorData.getActorsListData())
        actorListRecyclerView.layoutManager = LinearLayoutManager(view.context,RecyclerView.HORIZONTAL,false)
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    companion object {
        fun newInstance(): MovieDetailsFragment {
            return MovieDetailsFragment()
        }
    }

}