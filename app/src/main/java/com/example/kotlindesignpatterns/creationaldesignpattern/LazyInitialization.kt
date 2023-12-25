package com.example.kotlindesignpatterns.creationaldesignpattern

class AlertBox {

    var message: String? = null

    fun show() {
        println("AlertBox $this $message")
    }
}

class Window {
    val box by lazy { AlertBox() }

    fun showMessage(message:String){
        box.message = message
        box.show()
    }
}

class Window2 {
    lateinit var box: AlertBox

    fun showMessage(message: String) {
        box = AlertBox()
        box.message = message
        box.show()
    }
}