package com.alrayes.moviesworld.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<BINDING : ViewBinding> : Fragment() {

    private var _binding: BINDING? = null
    val binding get() = _binding!!
    protected lateinit var navController: NavController

    protected abstract fun onBind(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): BINDING

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = onBind(inflater, container)
        return binding.root
    }

    @CallSuper
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        try {
            navController = Navigation.findNavController(binding.root)
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}