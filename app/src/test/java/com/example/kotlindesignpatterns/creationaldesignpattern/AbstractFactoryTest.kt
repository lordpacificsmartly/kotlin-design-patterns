package com.example.kotlindesignpatterns.creationaldesignpattern

import org.assertj.core.api.Assertions
import org.junit.Test

class AbstractFactoryTest {

    @Test
    fun `test abstract factory`(){
        val dataSourceFactory = DataSourceFactory.createFactory<DatabaseDataSource>()
        val dataSource = dataSourceFactory.makeDataSource()

        println("Created datasource: $dataSource")

        Assertions.assertThat(dataSource).isInstanceOf(DatabaseDataSource::class.java)
    }
}