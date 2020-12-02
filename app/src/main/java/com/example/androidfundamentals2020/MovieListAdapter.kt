package com.example.androidfundamentals2020

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import coil.load
import androidx.recyclerview.widget.RecyclerView

class MovieListAdapter(private val movies: List<MovieListData>, private val clickListener: OnRecyclerItemClicked) : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val background: ImageView = listItemView.findViewById(R.id.background_image_view)
        val name: TextView = listItemView.findViewById(R.id.name_text_view)
        val tag: TextView = listItemView.findViewById(R.id.tag_text_view)
        val ratingStars = listItemView.findViewById<me.zhanghai.android.materialratingbar.MaterialRatingBar>(R.id.star_rating_bar)!!
        val rating: TextView = listItemView.findViewById(R.id.rating_text_view)
        val time: TextView = listItemView.findViewById(R.id.time_text_view)
        val buttonMovieSelect: Button = listItemView.findViewById(R.id.btn_movie_select)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val movieView = inflater.inflate(R.layout.view_holder_movie, parent, false)
        return ViewHolder(movieView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        movies[position].apply {
            holder.background.load(background)
            holder.name.text = name
            holder.rating.text = "$rating Reviews"
            holder.tag.text = tag
            holder.time.text = "$time min"
            holder.ratingStars.setProgress(ratingStars,true)
        }
        holder.buttonMovieSelect.setOnClickListener{ clickListener.onClick(position) }
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    interface OnRecyclerItemClicked {
        fun onClick(movieNum: Int)
    }
}
