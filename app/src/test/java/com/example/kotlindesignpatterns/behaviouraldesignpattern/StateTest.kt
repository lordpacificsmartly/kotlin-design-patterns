package com.example.kotlindesignpatterns.behaviouraldesignpattern

import org.assertj.core.api.Assertions
import org.junit.Test

class StateTest {

    @Test
    fun`test state`(){
        val authorizationPresenter = AuthorizationPresenter()
        authorizationPresenter.loginUser("admin")
        println(authorizationPresenter)
        Assertions.assertThat(authorizationPresenter.isAuthorized).isEqualTo(true)
        Assertions.assertThat(authorizationPresenter.username).isEqualTo("admin")


        authorizationPresenter.logoutUser()
        println(authorizationPresenter)
        Assertions.assertThat(authorizationPresenter.isAuthorized).isEqualTo(false)
        Assertions.assertThat(authorizationPresenter.username).isEqualTo("Unknown")
    }
}