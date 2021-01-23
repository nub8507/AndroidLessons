package com.example.androidfundamentals2020

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.androidfundamentals2020.db.DbMovieEntity


class MovieListAdapter(
    private val movies: List<DbMovieEntity>,
    private val clickListener: OnRecyclerItemClicked
) : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val background: ImageView = listItemView.findViewById(R.id.background_image_view)
        val name: TextView = listItemView.findViewById(R.id.name_text_view)
        val tag: TextView = listItemView.findViewById(R.id.tag_text_view)
        val ratingStars =
            listItemView.findViewById<me.zhanghai.android.materialratingbar.MaterialRatingBar>(R.id.star_rating_bar)!!
        val rating: TextView = listItemView.findViewById(R.id.rating_text_view)
        val time: TextView = listItemView.findViewById(R.id.time_text_view)
        val pgRating: TextView = listItemView.findViewById(R.id.pg_text_view)
        val buttonMovieSelect: Button = listItemView.findViewById(R.id.btn_movie_select)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val movieView = inflater.inflate(R.layout.view_holder_movie, parent, false)
        return ViewHolder(movieView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        bind(holder, movies[position])
    }

    fun bind(holder: ViewHolder, movie: DbMovieEntity) {
        movie.apply {
            holder.background.load(poster)
            holder.name.text = title
            holder.rating.text = "$numberOfRatings Reviews"
            var tagMovie: String = ""
            genres.forEach { tagMovie += it.name + "," }
            holder.tag.text = tagMovie
            holder.time.text = "$runtime min"
            holder.ratingStars.rating = ratings / 2
            holder.pgRating.text = "$minimumAge+"
        }
        holder.buttonMovieSelect.setOnClickListener { clickListener.onClick(movie) }
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    interface OnRecyclerItemClicked {
        fun onClick(movieData: DbMovieEntity)
    }
}
