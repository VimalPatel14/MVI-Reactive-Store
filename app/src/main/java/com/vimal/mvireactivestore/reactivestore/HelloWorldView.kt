package com.vimal.mvireactivestore.reactivestore

import com.hannesdorfmann.mosby3.mvp.MvpView
import io.reactivex.Observable

interface HelloWorldView : MvpView {
    /**
     * Emits button clicks
     */
    fun sayHelloWorldIntent(): Observable<Unit>

    /**
     * Renders the state in the UI
     */
    fun render(state: HelloWorldViewState)
}
