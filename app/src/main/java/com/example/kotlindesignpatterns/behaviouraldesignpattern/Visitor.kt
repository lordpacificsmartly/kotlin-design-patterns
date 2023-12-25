package com.example.kotlindesignpatterns.behaviouraldesignpattern

interface ReportElement  {
    fun<R> accept(visitor: ReportVisitor<R>): R
}

class FixedPriceContract(val costPerYear: Long): ReportElement {
    override fun <R> accept(visitor: ReportVisitor<R>): R = visitor.visit(this)
}

class TimeAndMaterialContract(val costPerHour: Long, val hours: Long): ReportElement {
    override fun <R> accept(visitor: ReportVisitor<R>): R = visitor.visit(this)
}

class SupportContract(val costPerMonth: Long): ReportElement {
    override fun <R> accept(visitor: ReportVisitor<R>): R = visitor.visit(this)
}


interface ReportVisitor<out R> {
    fun visit(contract:FixedPriceContract ):R
    fun visit(contract:TimeAndMaterialContract ):R
    fun visit(contract:SupportContract ):R
}

class MonthlyCostReportVisitor: ReportVisitor<Long> {
    override fun visit(contract: FixedPriceContract): Long = contract.costPerYear/12

    override fun visit(contract: TimeAndMaterialContract): Long = contract.costPerHour * contract.hours

    override fun visit(contract: SupportContract): Long = contract.costPerMonth
}

class YearlyCostReportVisitor: ReportVisitor<Long> {
    override fun visit(contract: FixedPriceContract): Long = contract.costPerYear

    override fun visit(contract: TimeAndMaterialContract): Long = contract.costPerHour * contract.hours

    override fun visit(contract: SupportContract): Long = contract.costPerMonth * 12

}