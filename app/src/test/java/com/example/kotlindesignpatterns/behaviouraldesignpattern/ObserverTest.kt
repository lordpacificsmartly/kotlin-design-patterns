package com.example.kotlindesignpatterns.behaviouraldesignpattern

import org.junit.Test

class ObserverTest {

    @Test
    fun`test observer`(){
        val editor = Editor()

        val logListener = LogOpenListener("path/to/log/file.txt")
        val emailListener = EmailNotificationListener("test@test.com")

        editor.events.subscribe("open",logListener )
        editor.events.subscribe("open", emailListener)
        editor.events.subscribe("save", emailListener)

        editor.openFile("test.txt")
        editor.saveFile()
    }
}