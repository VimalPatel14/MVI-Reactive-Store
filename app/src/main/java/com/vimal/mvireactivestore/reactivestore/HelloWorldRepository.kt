package com.vimal.mvireactivestore.reactivestore

import io.reactivex.Observable
import java.util.Random

/**
 * In a Production app, inject your Repository into your Use Case instead.
 */
object HelloWorldRepository {

    fun loadHelloWorldText(): Observable<String> = Observable.just(getRandomMessage())

    private fun getRandomMessage(): String {
        val messages = listOf("Hello World", "Hello Vimal", "Hello Patel", "Welcome")
        return messages[Random().nextInt(messages.size)]
    }
}