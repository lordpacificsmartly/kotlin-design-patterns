package com.example.kotlindesignpatterns.structuraldesignpattern

import org.assertj.core.api.Assertions
import org.junit.Test

class FacadeTest {

    @Test
    fun `test facade`(){

        val userRepo = UserRepository()
        val user = User("john")
        userRepo.save(user)
        val retrievedUser = userRepo.firstFirst()

        Assertions.assertThat(retrievedUser.login).isEqualTo("john")
    }
}