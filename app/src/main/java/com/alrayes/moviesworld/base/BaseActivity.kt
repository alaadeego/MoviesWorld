package com.alrayes.moviesworld.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<BINDING : ViewBinding> : AppCompatActivity() {
    private var _binding: BINDING? = null
    protected val binding get() = _binding!!

    protected abstract fun onBind(
        inflater: LayoutInflater
    ): BINDING

    override fun onCreate(savedInstanceState: Bundle?) {
        // handle change locale at runtime
        //LocaleManager.setLocale(this)
        super.onCreate(savedInstanceState)
        _binding =  onBind(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}