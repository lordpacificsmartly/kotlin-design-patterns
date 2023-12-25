package com.example.kotlindesignpatterns.behaviouraldesignpattern

import org.assertj.core.api.Assertions
import org.junit.Test

class VisitorTest {

    @Test
    fun `test visitor`(){
        val projectAlpha = FixedPriceContract(10_000)
        val projectBeta = SupportContract(500)
        val projectGamma = TimeAndMaterialContract(150, 10)
        val projectKappa = TimeAndMaterialContract(50, 50)

        val project = arrayListOf(projectAlpha, projectBeta, projectGamma, projectKappa)

        val monthlyCostVisitor = MonthlyCostReportVisitor()
        val monthlyCost = project.sumOf {
            it.accept(monthlyCostVisitor)
        }
        println("Monthly cost: $monthlyCost")
        Assertions.assertThat(monthlyCost).isEqualTo(5333)


        val yearlyCostVisitor = YearlyCostReportVisitor()
        val yearlyCost = project.sumOf {
            it.accept(yearlyCostVisitor)
        }
        println("Yearly cost: $yearlyCost")
        Assertions.assertThat(yearlyCost).isEqualTo(20_000)
    }
}