package com.example.kotlindesignpatterns.structuraldesignpattern


//3rd party functionality
// Cannot be changed
data class DisplayDataType(val index: Float, val data: String)

class DataDisplay{
    fun displayedData(data: DisplayDataType) {
        println("Data is displayed: ${data.index} - ${data.data}")
    }
}

//---------------------------
// Our code

data class DatabaseData(val position: Int, val amount:Int)

class DatabaseDataGenerator{
    fun generateData(): List<DatabaseData>{
        val list = arrayListOf<DatabaseData>()
        list.add(DatabaseData(2,2))
        list.add(DatabaseData(3,7))
        list.add(DatabaseData(4,23))
        return list
    }

}

interface DatabaseDataConverter {
    fun convertData(data: List<DatabaseData>): List<DisplayDataType>
}

class DataDisplayAdapter(private val display:DataDisplay ): DatabaseDataConverter{
    override fun convertData(data: List<DatabaseData>): List<DisplayDataType> {
        val returnList = arrayListOf<DisplayDataType>()
        for (datum in data){
            val ddt = DisplayDataType(datum.position.toFloat(), datum.amount.toString())
            display.displayedData(ddt)
            returnList.add(ddt)
        }
        return returnList
    }

}