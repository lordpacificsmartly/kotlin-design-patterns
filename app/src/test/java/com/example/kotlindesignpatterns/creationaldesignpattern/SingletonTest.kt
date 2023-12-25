package com.example.kotlindesignpatterns.creationaldesignpattern

import org.assertj.core.api.Assertions
import org.junit.Test

class SingletonTest {

    @Test
    fun `test singleton`(){
        println("Start")
        val networkDriver1 = NetworkDriver.log()
        val networkDriver2 = NetworkDriver.log()

        Assertions.assertThat(networkDriver1).isSameAs(NetworkDriver)
        Assertions.assertThat(networkDriver2).isSameAs(NetworkDriver)
    }
}