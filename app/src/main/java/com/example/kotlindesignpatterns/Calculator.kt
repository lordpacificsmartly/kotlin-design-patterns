package com.example.kotlindesignpatterns

class Calculator {

    fun sum(a: Int, b: Int) = a + b
}

fun main(){
    val sum = Calculator()

    val result = sum.sum(4,11)
    println("$result")
}