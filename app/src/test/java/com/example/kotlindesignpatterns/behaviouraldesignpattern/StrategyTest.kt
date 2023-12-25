package com.example.kotlindesignpatterns.behaviouraldesignpattern

import org.junit.Test

class StrategyTest {

    @Test
    fun`test strategy`(){

        val inputString = "LOREM ipsum DOLOR sit amet"

        val lowercasePrinter = Printer(lowercaseFormatter)
        lowercasePrinter.printString(inputString)


        val uppercasePrinter = Printer(uppercaseFormatter)
        uppercasePrinter.printString(inputString)
    }
}