package com.example.kotlindesignpatterns.behaviouraldesignpattern

class Printer(private val stringFormatterStrategy: (String) -> String) {

    fun printString(message: String) {
        println(stringFormatterStrategy(message))
    }
}

val lowercaseFormatter = { it: String -> it.lowercase()}
val uppercaseFormatter = { it: String -> it.uppercase()}