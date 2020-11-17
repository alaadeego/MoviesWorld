package com.alrayes.moviesworld.ui.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alrayes.moviesworld.base.Constants
import com.alrayes.moviesworld.data.models.response.MoviesResponse
import com.alrayes.moviesworld.databinding.ItemMovieBinding
import com.squareup.picasso.Picasso
import timber.log.Timber

class MoviesAdapter(private val context: Context) :
    ListAdapter<MoviesResponse.Movie, MoviesAdapter.OrdersHolder>(object :
        DiffUtil.ItemCallback<MoviesResponse.Movie>() {
        override fun areItemsTheSame(oldItem: MoviesResponse.Movie, newItem: MoviesResponse.Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MoviesResponse.Movie, newItem:MoviesResponse.Movie): Boolean {
            return oldItem == newItem
        }

    }) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersHolder {
        val binding: ItemMovieBinding =
            ItemMovieBinding.inflate(
                LayoutInflater.from(context), parent, false
            )
        return OrdersHolder(binding)
    }

    override fun onBindViewHolder(holder: OrdersHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class OrdersHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(orders:MoviesResponse.Movie) {
            binding.title.text = orders.title
            binding.date.text = orders.release_date
            binding.details.text = orders.overview
            Picasso.get().load(Constants.imageBaseUrl+orders.poster_path).into(binding.poster)
            Timber.tag("imageUrl").d(Constants.imageBaseUrl+orders.poster_path)
        }
    }



}
