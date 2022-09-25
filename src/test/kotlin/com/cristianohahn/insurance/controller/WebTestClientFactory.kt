package com.cristianohahn.insurance.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.getBean
import org.springframework.context.ApplicationContext
import org.springframework.http.MediaType
import org.springframework.http.codec.json.Jackson2JsonDecoder
import org.springframework.http.codec.json.Jackson2JsonEncoder
import org.springframework.test.web.reactive.server.WebTestClient

fun createWebTestClient(applicationContext: ApplicationContext): WebTestClient {
    val mapper = applicationContext.getBean<ObjectMapper>()

    return WebTestClient
        .bindToApplicationContext(applicationContext)
        .configureClient()
        .codecs { codecConfigurer ->
            codecConfigurer.defaultCodecs().jackson2JsonEncoder(Jackson2JsonEncoder(mapper, MediaType.APPLICATION_JSON))
            codecConfigurer.defaultCodecs().jackson2JsonDecoder(Jackson2JsonDecoder(mapper, MediaType.APPLICATION_JSON))
        }
        .build()
}
