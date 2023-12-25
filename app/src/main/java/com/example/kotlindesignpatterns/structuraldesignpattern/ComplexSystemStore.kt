package com.example.kotlindesignpatterns.structuraldesignpattern

class ComplexSystemStore(private val filePath: String) {

    private val cache: HashMap<String, String>

    init {
        println("Reading data from the file: $filePath")
        cache = HashMap()
    }
    //Read properties from file and put to cache

    fun store(key: String, value: String){
        cache[key] = value
    }

    fun read(key: String) = cache[key] ?: ""

    fun commit() = println("Storing cache data to file: $filePath")

}

data class User(val login: String)

//Facade
class UserRepository {
    private val systemPreferences = ComplexSystemStore("/data/default.prefs")

    fun save(user: User) {
        systemPreferences.store("USER_KEY", user.login)
        systemPreferences.commit()
    }

    fun firstFirst(): User = User(systemPreferences.read("USER_KEY"))
}