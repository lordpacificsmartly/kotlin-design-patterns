package com.example.kotlindesignpatterns.behaviouraldesignpattern

interface HandlerChain {

    fun addHeader(inputHeader: String): String
}

class AuthenticationHeader(private val token: String?, var next: HandlerChain? = null): HandlerChain {
    override fun addHeader(inputHeader: String) =
        "$inputHeader\nAuthorization: $token".let { next?.addHeader(it) ?: it }
}

class ContentTypeHeader(private val contentType: String, var next: HandlerChain? = null): HandlerChain {
    override fun addHeader(inputHeader: String) =
        "$inputHeader\nContentType: $contentType".let { next?.addHeader(it) ?: it}
}


class BodyPayloadHeader(private val body: String, var next: HandlerChain? = null): HandlerChain {
    override fun addHeader(inputHeader: String) =
        "$inputHeader\n$body".let { next?.addHeader(it) ?: it }
}