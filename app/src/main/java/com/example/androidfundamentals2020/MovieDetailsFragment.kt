package com.example.androidfundamentals2020

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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

        val actors = MovieActorData.getActorsListData()
        val actorListRecyclerView = view.findViewById<RecyclerView>(R.id.movie_detail_actor_recycler_view)
        val actorListEmptyText = view.findViewById<TextView>(R.id.empty_recycler_text_view)
        actorListRecyclerView.adapter = MovieDetailsActorAdapter(actors)
        actorListRecyclerView.layoutManager = LinearLayoutManager(view.context,RecyclerView.HORIZONTAL,false)
        if(actors.size > 0){
            actorListRecyclerView.visibility =android.view.View.VISIBLE
            actorListEmptyText.visibility =android.view.View.GONE
        }else{
            actorListRecyclerView.visibility =android.view.View.INVISIBLE
            actorListEmptyText.visibility =android.view.View.VISIBLE
        }

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