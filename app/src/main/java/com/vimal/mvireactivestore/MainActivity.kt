package com.vimal.mvireactivestore

import android.os.Bundle
import android.widget.Toast
import com.hannesdorfmann.mosby3.mvi.MviActivity
import com.jakewharton.rxbinding2.view.clicks
import com.vimal.mvireactivestore.databinding.ActivityMainBinding
import com.vimal.mvireactivestore.reactivestore.HelloWorldPresenter
import com.vimal.mvireactivestore.reactivestore.HelloWorldView
import com.vimal.mvireactivestore.reactivestore.HelloWorldViewState
import com.vimal.mvireactivestore.reactivestore.visible

class MainActivity : MviActivity<HelloWorldView, HelloWorldPresenter>(), HelloWorldView {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun createPresenter() = HelloWorldPresenter()

    override fun sayHelloWorldIntent() = binding.helloWorldButton.clicks()

    override fun render(state: HelloWorldViewState) {
        when (state) {
            is HelloWorldViewState.LoadingState -> renderLoadingState()
            is HelloWorldViewState.DataState -> renderDataState(state)
            is HelloWorldViewState.ErrorState -> renderErrorState(state)
        }
    }

    private fun renderLoadingState() {
        binding.loadingIndicator.visible = true
        binding.helloWorldTextview.visible = false
    }

    private fun renderDataState(dataState: HelloWorldViewState.DataState) {
        binding.loadingIndicator.visible = false
        binding.helloWorldTextview.apply {
            visible = true
            text = dataState.greeting
        }
    }

    private fun renderErrorState(errorState: HelloWorldViewState.ErrorState) {
        binding.loadingIndicator.visible = false
        binding.helloWorldTextview.visible = false
        Toast.makeText(this, "error ${errorState.error}", Toast.LENGTH_LONG).show()
    }
}