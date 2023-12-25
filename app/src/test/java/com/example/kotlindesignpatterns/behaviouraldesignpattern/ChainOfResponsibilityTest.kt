package com.example.kotlindesignpatterns.behaviouraldesignpattern

import org.assertj.core.api.Assertions
import org.junit.Test

class ChainOfResponsibilityTest {

    @Test
    fun`test chain of responsibility`(){

        val authenticationHeader = AuthenticationHeader("123456")
        val contentTypeHeader = ContentTypeHeader("json")
        val bodyPayloadHeader = BodyPayloadHeader("Body: {\"username\" = \"john\"}")

        authenticationHeader.next = contentTypeHeader
        contentTypeHeader.next = bodyPayloadHeader

        val messageWithAuthentication = authenticationHeader.addHeader("Headers with authentication")
        println(messageWithAuthentication)

        println("---------------------------------------------")

        val messageWithoutAuthenticationHeader = contentTypeHeader.addHeader("Headers with OUT authentication")
        println(messageWithoutAuthenticationHeader)

        Assertions.assertThat(messageWithAuthentication).isEqualTo(
            """
                Headers with authentication
                Authorization: 123456
                ContentType: json
                Body: {"username" = "john"}
            """.trimIndent()
        )

        Assertions.assertThat(messageWithoutAuthenticationHeader).isEqualTo(
            """
                Headers with OUT authentication
                ContentType: json
                Body: {"username" = "john"}
            """.trimIndent()
        )
    }
}