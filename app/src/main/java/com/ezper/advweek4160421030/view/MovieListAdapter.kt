package com.ezper.advweek4160421030.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ezper.advweek4160421030.databinding.MovieListItemBinding
import com.ezper.advweek4160421030.model.Director
import com.ezper.advweek4160421030.model.Movie

class MovieListAdapter(val movieList:ArrayList<Movie>)
    :RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>() {
        class MovieViewHolder(var binding: MovieListItemBinding)
            :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        var binding = MovieListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.binding.txtTitle.text = movieList[position].title
        holder.binding.txtGenre.text = movieList[position].genre
        holder.binding.txtDirectorName.text = movieList[position].director?.name
        holder.binding.txtDirectorBirthYear.text = movieList[position].director?.birthYear?.toString()
        holder.binding.txtDirectorNationality.text = movieList[position].director?.nationality
        holder.binding.txtRelease.text = movieList[position].releaseYear.toString()
        holder.binding.txtRating.text = movieList[position].rating.toString()
        holder.binding.txtCast1.text = movieList[position].cast[0]
        holder.binding.txtCast2.text = movieList[position].cast[1]
        holder.binding.txtCast3.text = movieList[position].cast[2]
        holder.binding.txtPlot.text = movieList[position].plot

    }

    fun updateMovieList(newMovieList:ArrayList<Movie>) {
        movieList.clear()
        movieList.addAll(newMovieList)
        notifyDataSetChanged()
    }
}