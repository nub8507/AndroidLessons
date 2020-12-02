package com.example.androidfundamentals2020

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import coil.load
import androidx.recyclerview.widget.RecyclerView

class MovieDetailsActorAdapter(private val actors: List<MovieActorData>) : RecyclerView.Adapter<MovieDetailsActorAdapter.ViewHolder>() {

    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val actorAvatar: ImageView = listItemView.findViewById(R.id.actor_image_view)
        val actorName: TextView = listItemView.findViewById(R.id.actor_text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val movieView = inflater.inflate(R.layout.view_holder_actor, parent, false)
        return ViewHolder(movieView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.actorAvatar.load(actors[position].image)
        holder.actorName.text = actors[position].name
    }

    override fun getItemCount(): Int {
        return actors.size
    }
}