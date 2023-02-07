package com.vimal.mvireactivestore.reactivestore

sealed class HelloWorldViewState {
    object LoadingState : HelloWorldViewState()
    data class DataState(val greeting: String) : HelloWorldViewState()
    data class ErrorState(val error: Throwable) : HelloWorldViewState()
}