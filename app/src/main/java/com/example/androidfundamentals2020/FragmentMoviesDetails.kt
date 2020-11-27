package com.example.androidfundamentals2020

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidfundamentals2020.databinding.FragmentMoviesDetailsBinding

class FragmentMoviesDetails : Fragment() {
    private var binding: FragmentMoviesDetailsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_details, container, false)
    }

    private fun btnBackClick() {
        val listener = activity as OnMoviesDetailsListener?
        listener?.onMoviesDetailsButtonBackClicked()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentMoviesDetailsBinding.bind(view)

        binding!!.imageButtonBack.setOnClickListener{btnBackClick()}
        binding!!.buttonBack.setOnClickListener{btnBackClick()}
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    interface OnMoviesDetailsListener {
        fun onMoviesDetailsButtonBackClicked()
    }
}