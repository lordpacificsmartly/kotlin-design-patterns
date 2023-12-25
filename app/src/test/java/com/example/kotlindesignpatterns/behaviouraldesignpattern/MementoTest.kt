package com.example.kotlindesignpatterns.behaviouraldesignpattern

import org.assertj.core.api.Assertions
import org.junit.Test

class MementoTest {
    @Test
    fun `test memento`() {
        val originator = Originator("initial state")
        val careTaker = CareTaker()
        careTaker.saveState(originator.createMemento())

        originator.state = "State 1"
        careTaker.saveState(originator.createMemento())
        println("Current state: ${originator.state}")

        originator.state = "State 2"
        careTaker.saveState(originator.createMemento())
        println("Current state: ${originator.state}")

        Assertions.assertThat(originator.state).isEqualTo("State 2")

        originator.restoreMemento(careTaker.restore(1))
        println("Current state: ${originator.state}")
        Assertions.assertThat(originator.state).isEqualTo("State 1")

        originator.restoreMemento(careTaker.restore(0))
        println("Current state: ${originator.state}")
        Assertions.assertThat(originator.state).isEqualTo("initial state")

        originator.restoreMemento(careTaker.restore(2))
        println("Current state: ${originator.state}")
        Assertions.assertThat(originator.state).isEqualTo("State 2")

    }
}