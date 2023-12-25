package com.example.kotlindesignpatterns.behaviouraldesignpattern

import java.io.File

interface EventListener {
    fun update(eventType: String?, file: File)
}

class EventManager(vararg operations: String) {
    private var listeners = hashMapOf<String, ArrayList<EventListener>>()

    init {
        for (operation in operations) {
            listeners[operation] = ArrayList()
        }
    }

    fun subscribe(eventType: String?, listener: EventListener) {
        val user = listeners[eventType]
        user?.add(listener)

    }

    fun unsubscribe(eventType: String?, listener: EventListener) {
        val users = listeners[eventType]
        users?.remove(listener)
    }

    fun notify(eventType: String, file: File) {
        val users = listeners[eventType]
        users?.let {
            for (listener in it) {
                listener.update(eventType, file)
            }
        }
    }
}

class Editor {
    var events = EventManager("open", "save")

    private var file: File? = null

    fun openFile(filePath: String) {
        file = File(filePath)
        events.notify("open", file!!)
    }

    fun saveFile() {
        file?.let {
            events.notify("save", file!!)
        }
    }
}

class EmailNotificationListener(private val email: String):EventListener {
    override fun update(eventType: String?, file: File) {
        println("Email to $email: Someone has performed $eventType operation with the file ${file.name}")
    }
}

class LogOpenListener(private var fileName: String): EventListener {
    override fun update(eventType: String?, file: File) {
        println("Save to log $fileName: Someone has performed $eventType operation with the file ${file.name}")
    }
}