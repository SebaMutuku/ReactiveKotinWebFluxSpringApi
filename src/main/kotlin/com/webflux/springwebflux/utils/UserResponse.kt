package com.webflux.springwebflux.utils

import org.springframework.http.HttpStatus
import reactor.core.CoreSubscriber
import reactor.core.publisher.Mono
import java.util.*

class UserResponse : Mono<UserResponse>() {
    var token: String = ""
    var message: String = ""
    var status: HttpStatus = HttpStatus.NOT_FOUND
    override fun subscribe(coreSubscriber: CoreSubscriber<in UserResponse>) {}
}