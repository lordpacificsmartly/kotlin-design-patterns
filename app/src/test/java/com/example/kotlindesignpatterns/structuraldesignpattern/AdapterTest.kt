package com.example.kotlindesignpatterns.structuraldesignpattern

import org.assertj.core.api.Assertions
import org.junit.Test

class AdapterTest {

    @Test
    fun`test adapter`(){
        val generator = DatabaseDataGenerator()
        val generatedData = generator.generateData()
        val adapter = DataDisplayAdapter(DataDisplay())
        val convertData = adapter.convertData(generatedData)

        Assertions.assertThat(convertData.size).isEqualTo(3)
        Assertions.assertThat(convertData[1].index).isEqualTo(3f)
        Assertions.assertThat(convertData[1].data).isEqualTo("7")
    }
}