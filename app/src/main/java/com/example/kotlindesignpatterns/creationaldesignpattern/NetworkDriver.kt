package com.example.kotlindesignpatterns.creationaldesignpattern

object NetworkDriver {

    init {
        println("Initializing:... $this")
    }

    fun log(): NetworkDriver = apply { println("Network Driver $this") }

}

