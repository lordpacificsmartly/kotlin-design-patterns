package com.example.kotlindesignpatterns.structuraldesignpattern

import org.assertj.core.api.Assertions
import org.junit.Test

class CompositeTest {

    @Test
    fun `test composite`(){

        val memory = Memory()
            .add(ROM())
            .add(RAM())

        val pc = Computer()
            .add(memory)
            .add(Processor())
            .add(HardDrive())

        println("PC price: ${pc.price}")

        Assertions.assertThat(pc.name).isEqualTo("PC")
        Assertions.assertThat(pc.price).isEqualTo(1425)
    }
}