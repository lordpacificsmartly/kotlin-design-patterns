package com.example.kotlindesignpatterns.structuraldesignpattern

import org.assertj.core.api.Assertions
import org.junit.Test

class BridgeTest {

    @Test
    fun`test bridge`(){

        val tv = TV()
        val radio = Radio()

        val tvRemote = BasicRemote(tv)
        val radioRemote = BasicRemote(radio)

        tvRemote.volumeUp()
        tvRemote.volumeUp()
        tvRemote.volumeDown()

        radioRemote.volumeUp()
        radioRemote.volumeUp()
        radioRemote.volumeUp()
        radioRemote.volumeDown()

        Assertions.assertThat(tv.volume).isEqualTo(1)
        Assertions.assertThat(radio.volume).isEqualTo(2)
    }
}