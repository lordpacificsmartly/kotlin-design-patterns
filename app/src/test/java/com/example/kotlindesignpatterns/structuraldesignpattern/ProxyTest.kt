package com.example.kotlindesignpatterns.structuraldesignpattern

import org.junit.Test

class ProxyTest {

    @Test
    fun`test proxy`(){

        val image = ProxyImage("test.jpg")

        //load image from disk
        image.display()
        println("---------------------------------")

        //load image from cache
        image.display()
    }
}