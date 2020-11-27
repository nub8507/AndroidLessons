package com.example.androidfundamentals2020

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidfundamentals2020.databinding.FragmentMoviesDetailsBinding
import com.example.androidfundamentals2020.databinding.FragmentMoviesListBinding

class FragmentMoviesList : Fragment() {

    private var binding: FragmentMoviesListBinding? = null
    private var listener: OnMoviesListListener? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentMoviesListBinding.bind(view)
        binding!!.btnMovieSelect.setOnClickListener { listener?.onMoviesListMovieClicked()}
    }

    override fun onDestroyView() {
        binding = null
        listener = null
        super.onDestroyView()
    }

    fun setClickListener(l: OnMoviesListListener?) {
        listener = l
    }

    interface OnMoviesListListener {
        fun onMoviesListMovieClicked()
    }
}