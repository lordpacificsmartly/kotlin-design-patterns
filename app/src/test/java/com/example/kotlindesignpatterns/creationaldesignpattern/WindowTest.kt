package com.example.kotlindesignpatterns.creationaldesignpattern

import org.assertj.core.api.Assertions
import org.junit.Test

class WindowTest {

    @Test
    fun`test window`(){
        val window = Window()
        window.showMessage("Hello window")

        Assertions.assertThat(window.box).isNotNull
    }

    @Test
    fun`test window2`(){
        val window2 = Window2()
        window2.showMessage("Second window")

        Assertions.assertThat(window2.box).isNotNull
    }
}