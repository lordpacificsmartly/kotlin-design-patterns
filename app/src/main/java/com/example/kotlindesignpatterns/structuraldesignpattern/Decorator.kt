package com.example.kotlindesignpatterns.structuraldesignpattern

interface CoffeeMachine {

    fun makeSmallCoffee()
    fun makeLargeCoffee()
}

class NormalCoffeeMachine: CoffeeMachine {
    override fun makeSmallCoffee() {
        println("Normal coffee machine: Making small coffee")
    }

    override fun makeLargeCoffee() {
        println("Normal coffee machine: Making large coffee")
    }
}

//Decorator

class EnhancedCoffeeMachine(private val coffeeMachine: CoffeeMachine): CoffeeMachine by coffeeMachine {

    //Overriding behaviour
    override fun makeLargeCoffee() {
        println("Enhanced coffee machine: Making large coffee")
    }

    //Expand behaviour
    fun makeMilkCoffee(){
        println("Enhanced coffee machine: Making milk coffee")
        coffeeMachine.makeSmallCoffee()
        println("Enhanced coffee machine: Adding milk")

    }


}