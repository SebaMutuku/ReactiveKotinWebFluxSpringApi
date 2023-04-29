package com.webflux.springwebflux.utils

import org.springframework.http.HttpStatus
import reactor.core.CoreSubscriber
import reactor.core.publisher.Flux


data class ResponseDTO(
        val status: HttpStatus? = null,
        val payload: Any? = null,
        val message: String = "")
