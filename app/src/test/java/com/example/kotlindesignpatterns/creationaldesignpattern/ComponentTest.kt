package com.example.kotlindesignpatterns.creationaldesignpattern

import org.assertj.core.api.Assertions
import org.junit.Test

class ComponentTest {

    @Test
    fun`test builder`(){
        val component = Component.Builder()
            .setParam1("Some value")
            .setParam3(true)
            .build()

        println(component)
        println(component.param1)
        println(component.param3)


        Assertions.assertThat(component.param1).isEqualTo("Some value")
        Assertions.assertThat(component.param3).isEqualTo(true)
        Assertions.assertThat(component.param2).isEqualTo(null)

    }
}