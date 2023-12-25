package com.example.kotlindesignpatterns.behaviouraldesignpattern

import org.junit.Test

class MediatorTest {

    @Test
    fun`test mediator`(){
        val mediator = Mediator()
        val alice = ChatUser(mediator,"alice")
        val bob = ChatUser(mediator,"bob")
        val carol = ChatUser(mediator,"carol")

        mediator.addUser(alice).addUser(bob).addUser(carol)

        carol.send("Hi everyone")
    }
}