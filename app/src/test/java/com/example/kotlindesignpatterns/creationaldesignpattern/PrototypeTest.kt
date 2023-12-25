package com.example.kotlindesignpatterns.creationaldesignpattern

import org.assertj.core.api.Assertions
import org.junit.Test

class PrototypeTest {

    @Test
    fun`test prototype`(){

        ShapeCache.loadCache()
        val clonedShape1 = ShapeCache.getShape("1")
        val clonedShape2 = ShapeCache.getShape("2")
        val clonedShape3 = ShapeCache.getShape("3")

        clonedShape1.draw()
        clonedShape2.draw()
        clonedShape3.draw()

        Assertions.assertThat(clonedShape1.type).isEqualTo("Circle")
        Assertions.assertThat(clonedShape2.type).isEqualTo("Square")
        Assertions.assertThat(clonedShape3.type).isEqualTo("Rectangle")

    }
}