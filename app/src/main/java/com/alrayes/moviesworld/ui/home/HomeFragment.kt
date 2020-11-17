package com.alrayes.moviesworld.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alrayes.moviesworld.BuildConfig
import com.alrayes.moviesworld.R
import com.alrayes.moviesworld.base.BaseFragment
import com.alrayes.moviesworld.databinding.FragmentHomeBinding
import com.alrayes.moviesworld.ui.home.adapters.MoviesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class HomeFragment  : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel  by viewModel()
    private val moviesAdapter by lazy { MoviesAdapter(requireContext()) }

    override fun onBind(inflater: LayoutInflater, container: ViewGroup?): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchMovies()
        setupRecycler()
        setupObservers()

    }
    private fun setupRecycler() {
        binding.rvMovies.adapter = moviesAdapter
    }

    private fun setupObservers() {
    viewModel.moviesList.observe(viewLifecycleOwner,androidx.lifecycle.Observer {
        Timber.tag("observe").d("observe")

        moviesAdapter.submitList(it)

    })
    }
}