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
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}