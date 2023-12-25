package com.example.kotlindesignpatterns.creationaldesignpattern

import org.assertj.core.api.Assertions
import org.junit.Test

class FactoryMethodTest {

    @Test
    fun `test currency`(){
        val greekCurrency = CurrencyFactory.currencyForCountry(Greece("")).code
        println("Greek currency: $greekCurrency")

        val usaCurrency = CurrencyFactory.currencyForCountry(USA("")).code
        println("USA currency: $usaCurrency")

        Assertions.assertThat(greekCurrency).isEqualTo("EUR")
        Assertions.assertThat(usaCurrency).isEqualTo("USD")
    }
}