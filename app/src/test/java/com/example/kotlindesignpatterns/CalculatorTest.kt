package com.example.kotlindesignpatterns

import org.assertj.core.api.Assertions
import org.junit.Test

class CalculatorTest {

    @Test
    fun `test sum`(){
        val calc = Calculator()
        Assertions.assertThat(calc.sum(3,5)).isEqualTo(8)
    }
}