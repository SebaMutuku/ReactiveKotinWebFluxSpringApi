package com.webflux.springwebflux.utils

import org.springframework.http.HttpStatus
import reactor.core.CoreSubscriber
import reactor.core.publisher.Flux


class GeneralResponse : Flux<GeneralResponse>() {
    var status: HttpStatus? = null
    var payload: Any? = null
    var message: String = ""
    override fun subscribe(coreSubscriber: CoreSubscriber<in GeneralResponse>) {}
}
