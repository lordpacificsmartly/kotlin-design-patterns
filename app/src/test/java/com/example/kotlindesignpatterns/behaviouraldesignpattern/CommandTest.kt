package com.example.kotlindesignpatterns.behaviouraldesignpattern

import org.junit.Test

class CommandTest {

    @Test
    fun`test command`(){

        CommandProcessor()
            .addToQueue(OrderAddCommand(1L))
            .addToQueue(OrderAddCommand(2L))
            .addToQueue(OrderPayCommand(2L))
            .addToQueue(OrderPayCommand(1L))
            .processCommands()
    }
}