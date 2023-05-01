package com.webflux.springwebflux.exception

import org.springframework.http.HttpStatus
import java.util.*

data class GenericExceptionHandler(val exceptionMessage: String, val httpStatus: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR, val date: Date? = Date()) : Exception() {
    constructor(exceptionMessage: String) : this(exceptionMessage, HttpStatus.INTERNAL_SERVER_ERROR, Date())
    constructor(exceptionMessage: String, httpStatus: HttpStatus) : this(exceptionMessage, httpStatus, Date())
}
