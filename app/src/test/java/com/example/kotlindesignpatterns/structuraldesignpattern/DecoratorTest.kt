package com.example.kotlindesignpatterns.structuraldesignpattern

import org.junit.Test

class DecoratorTest {

    @Test
    fun`test decorator`(){
        val normalMachine = NormalCoffeeMachine()
        val enhancedCoffeeMachine = EnhancedCoffeeMachine(normalMachine)

        enhancedCoffeeMachine.makeSmallCoffee()
        println("-------------------------------------")
        enhancedCoffeeMachine.makeLargeCoffee()
        println("-------------------------------------")
        enhancedCoffeeMachine.makeMilkCoffee()

    }
}